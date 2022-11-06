package pl.witex.medicaresystemapi.model

import pl.witex.medicaresystemapi.model.doctor.Doctor
import pl.witex.medicaresystemapi.model.patient.Patient
import java.time.LocalDateTime

data class Visit(
    val date: LocalDateTime,
    val hour: Int,
    val place: String,
    val mainDoctor: Doctor,
    val patient: Patient
)