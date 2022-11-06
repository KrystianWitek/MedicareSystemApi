package pl.witex.medicaresystemapi.model.doctor

import pl.witex.medicaresystemapi.model.Specialization
import pl.witex.medicaresystemapi.model.PersonName
import java.util.UUID

data class DoctorResponse(
    val id: UUID,
    val name: PersonName,
    val specialization: Specialization
)

