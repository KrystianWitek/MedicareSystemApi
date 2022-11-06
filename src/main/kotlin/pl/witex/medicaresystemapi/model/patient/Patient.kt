package pl.witex.medicaresystemapi.model.patient

import pl.witex.medicaresystemapi.model.Address
import pl.witex.medicaresystemapi.model.PersonName

data class Patient(
    val name: PersonName,
    val address: Address
)