package pl.witex.medicaresystemapi.model.dto

import pl.witex.medicaresystemapi.model.dto.Address
import pl.witex.medicaresystemapi.model.dto.PersonName
import java.util.UUID

data class Patient(
    val name: PersonName,
    val address: Address
)