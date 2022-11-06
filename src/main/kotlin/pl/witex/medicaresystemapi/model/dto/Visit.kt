package pl.witex.medicaresystemapi.model.dto

import java.time.LocalDateTime

data class Visit(
    val date: LocalDateTime,
    val hour: Int,
    val place: String,
    val mainDoctor: Doctor,
    val patient: Patient
)