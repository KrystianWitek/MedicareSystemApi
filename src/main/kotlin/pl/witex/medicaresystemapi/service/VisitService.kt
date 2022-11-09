package pl.witex.medicaresystemapi.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import pl.witex.medicaresystemapi.db.entity.toDto
import pl.witex.medicaresystemapi.db.repository.VisitRepository
import pl.witex.medicaresystemapi.model.doctor.toEntity
import pl.witex.medicaresystemapi.model.patient.toEntity
import pl.witex.medicaresystemapi.model.visit.VisitRequest
import pl.witex.medicaresystemapi.model.visit.VisitResponse
import pl.witex.medicaresystemapi.model.visit.VisitUpdate
import pl.witex.medicaresystemapi.model.visit.toEntity
import java.util.*

@Component
class VisitService(
    private val repository: VisitRepository,
    private val doctorService: DoctorService,
    private val patientService: PatientService
) {
    fun getByPatientId(id: UUID, page: Int, size: Int): Page<VisitResponse> =
        repository.findAllByPatientId(id, PageRequest.of(page, size))
            .map { it.toDto() }

    fun create(visit: VisitRequest) {
        val visitToSave = visit.toEntity(
            patient = patientService.getById(visit.patientId).toEntity(),
            doctor = doctorService.getById(visit.doctorId).toEntity()
        )
        repository.save(visitToSave)
    }

    fun updateHour(id: UUID, visit: VisitUpdate) {
        repository.findByIdOrNull(id)?.also {
            it.hour = visit.hour
        } ?: throw NoSuchElementException("Missing visit with id: $id")
    }

    fun delete(id: UUID) {
        repository.deleteById(id)
    }

}