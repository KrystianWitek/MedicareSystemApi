package pl.witex.medicaresystemapi.model.patient

import pl.witex.medicaresystemapi.model.Address
import pl.witex.medicaresystemapi.model.PersonName
import java.util.UUID

data class PatientResponse(
    val id: UUID,
    val name: PersonName,
    val address: Address
)

