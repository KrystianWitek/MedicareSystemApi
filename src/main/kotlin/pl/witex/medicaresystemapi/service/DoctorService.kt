package pl.witex.medicaresystemapi.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import pl.witex.medicaresystemapi.db.entity.toDto
import pl.witex.medicaresystemapi.db.repository.DoctorRepository
import pl.witex.medicaresystemapi.model.doctor.DoctorRequest
import pl.witex.medicaresystemapi.model.doctor.DoctorResponse
import pl.witex.medicaresystemapi.model.doctor.toEntity
import java.util.*

@Component
class DoctorService(
    private val repository: DoctorRepository
) {
    fun getAll(page: Int, size: Int): Page<DoctorResponse> =
        repository.findAll(
            PageRequest.of(page, size)
        ).map { it.toDto() }

    fun getById(id: UUID): DoctorResponse =
        repository.findByIdOrNull(id)?.toDto()
            ?: throw NoSuchElementException("Missing doctor with id: $id")

    fun add(Doctor: DoctorRequest): UUID =
        repository.save(Doctor.toEntity()).id

    fun update(id: UUID, doctor: DoctorRequest) {
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