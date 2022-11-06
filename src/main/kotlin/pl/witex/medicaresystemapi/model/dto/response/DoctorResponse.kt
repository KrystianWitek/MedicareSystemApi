package pl.witex.medicaresystemapi.model.dto.response

import pl.witex.medicaresystemapi.model.Specialization
import pl.witex.medicaresystemapi.model.dto.Address
import pl.witex.medicaresystemapi.model.dto.PersonName
import java.util.UUID

data class DoctorResponse(
    val id: UUID,
    val name: PersonName,
    val specialization: Specialization
)
