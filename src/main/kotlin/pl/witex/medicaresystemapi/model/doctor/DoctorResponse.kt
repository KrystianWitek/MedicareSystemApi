package pl.witex.medicaresystemapi.model.doctor

import pl.witex.medicaresystemapi.db.entity.Doctor
import pl.witex.medicaresystemapi.model.PersonName
import pl.witex.medicaresystemapi.model.Specialization
import java.util.*

data class DoctorResponse(
    val id: UUID,
    val name: PersonName,
    val specialization: Specialization
)

fun DoctorResponse.toEntity() =
    Doctor().also {
        it.id = id
        it.firstname = name.firstname
        it.surname = name.surname
        it.specialization = specialization
    }