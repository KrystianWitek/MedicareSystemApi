package pl.witex.medicaresystemapi.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import pl.witex.medicaresystemapi.db.entity.toDto
import pl.witex.medicaresystemapi.db.repository.PatientRepository
import pl.witex.medicaresystemapi.db.repository.VisitRepository
import pl.witex.medicaresystemapi.model.Visit
import pl.witex.medicaresystemapi.model.doctor.toEntity
import pl.witex.medicaresystemapi.model.patient.toEntity
import pl.witex.medicaresystemapi.model.toEntity
import java.util.*

@Component
class VisitService(
    private val repository: VisitRepository,
    private val doctorService: DoctorService,
    private val patientService: PatientService
) {
    fun getAll(): List<Visit> = repository.findAll().map { it.toDto() }

    fun getById(id: UUID): Visit =
        repository.findByIdOrNull(id)?.toDto()
            ?: throw NoSuchElementException("Missing visit with id: $id")

    fun add(visit: Visit): UUID {
        val visitToSave = visit.toEntity(
            patient = patientService.getById(visit.patientId).toEntity(),
            doctor = doctorService.getById(visit.doctorId).toEntity()
        )
        return repository.save(visitToSave).id
    }

    fun update(id: UUID, visit: Visit) {
        repository.findByIdOrNull(id)?.also {
            it.date = visit.date
            it.hour = visit.hour
            it.place = visit.place
            it.doctor = doctorService.getById(visit.doctorId).toEntity()
        } ?: throw NoSuchElementException("Missing visit with id: $id")
    }

    fun delete(id: UUID) {
        repository.deleteById(id)
    }

}