package pl.witex.medicaresystemapi.model.visit

import java.time.LocalDateTime
import java.util.*
import pl.witex.medicaresystemapi.db.entity.Doctor as DoctorEntity
import pl.witex.medicaresystemapi.db.entity.Patient as PatientEntity
import pl.witex.medicaresystemapi.db.entity.Visit as VisitEntity

data class VisitRequest(
    val date: LocalDateTime,
    val hour: Int,
    val place: String,
    val doctorId: UUID,
    val patientId: UUID
)

fun VisitRequest.toEntity(doctor: DoctorEntity, patient: PatientEntity) =
    VisitEntity().also {
        it.date = date
        it.hour = hour
        it.place = place
        it.doctor = doctor
        it.patient = patient
    }