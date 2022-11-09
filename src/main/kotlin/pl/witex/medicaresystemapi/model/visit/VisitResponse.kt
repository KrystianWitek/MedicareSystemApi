package pl.witex.medicaresystemapi.model.visit

import pl.witex.medicaresystemapi.db.entity.Doctor
import pl.witex.medicaresystemapi.db.entity.Patient
import java.time.LocalDateTime
import java.util.*
import pl.witex.medicaresystemapi.db.entity.Visit as VisitEntity

data class VisitResponse(
    val id: UUID,
    val date: LocalDateTime,
    val hour: Int,
    val place: String,
    val doctorId: UUID,
    val patientId: UUID
)

fun VisitResponse.toEntity(doctor: Doctor, patient: Patient) =
    VisitEntity().also {
        it.date = date
        it.hour = hour
        it.place = place
        it.doctor = doctor
        it.patient = patient
    }