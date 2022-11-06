package pl.witex.medicaresystemapi.model.dto

import pl.witex.medicaresystemapi.model.Specialization
import pl.witex.medicaresystemapi.model.dto.PersonName

data class Doctor(
    val name: PersonName,
    val specialization: Specialization
)

