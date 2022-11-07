package pl.witex.medicaresystemapi.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import pl.witex.medicaresystemapi.db.entity.toDto
import pl.witex.medicaresystemapi.db.repository.DoctorRepository
import pl.witex.medicaresystemapi.model.doctor.Doctor
import pl.witex.medicaresystemapi.model.doctor.toEntity
import java.util.*

@Component
class DoctorService(
    private val repository: DoctorRepository
) {
    fun getAll(): List<Doctor> = repository.findAll().map { it.toDto() }

    fun getById(id: UUID): Doctor =
        repository.findByIdOrNull(id)?.toDto()
            ?: throw NoSuchElementException("Missing doctor with id: $id")

    fun add(Doctor: Doctor): UUID =
        repository.save(Doctor.toEntity()).id

    fun update(id: UUID, doctor: Doctor) {
        repository.findByIdOrNull(id)?.also {
            it.firstname = doctor.name.firstname
            it.surname = doctor.name.surname
            it.specialization = doctor.specialization
        } ?: throw NoSuchElementException("Missing doctor with id: $id")
    }

    fun delete(id: UUID) {
        repository.deleteById(id)
    }
}