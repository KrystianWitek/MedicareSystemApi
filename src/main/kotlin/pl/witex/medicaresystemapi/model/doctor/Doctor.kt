package pl.witex.medicaresystemapi.model.doctor

import pl.witex.medicaresystemapi.model.PersonName
import pl.witex.medicaresystemapi.model.Specialization

data class Doctor(
    val name: PersonName,
    val specialization: Specialization
)

