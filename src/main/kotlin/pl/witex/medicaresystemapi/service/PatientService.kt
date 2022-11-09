package pl.witex.medicaresystemapi.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import pl.witex.medicaresystemapi.db.entity.toDto
import pl.witex.medicaresystemapi.db.repository.PatientRepository
import pl.witex.medicaresystemapi.model.patient.PatientRequest
import pl.witex.medicaresystemapi.model.patient.PatientResponse
import pl.witex.medicaresystemapi.model.patient.toEntity
import java.util.*

@Component
class PatientService(
    private val repository: PatientRepository
) {
    fun getAll(page: Int, size: Int): Page<PatientResponse> =
        repository.findAll(
            PageRequest.of(page, size)
        ).map { it.toDto() }

    fun getById(id: UUID): PatientResponse =
        repository.findByIdOrNull(id)?.toDto()
            ?: throw NoSuchElementException("Missing patient with id: $id")

    fun add(patient: PatientRequest): UUID =
        repository.save(patient.toEntity()).id

    fun update(id: UUID, patient: PatientRequest) {
        repository.findByIdOrNull(id)?.also {
            it.firstname = patient.name.firstname
            it.surname = patient.name.surname
            it.address = patient.address
        } ?: throw NoSuchElementException("Missing patient with id: $id")
    }

    fun delete(id: UUID) {
        repository.deleteById(id)
    }
}