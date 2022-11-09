package pl.witex.medicaresystemapi.model.patient

import pl.witex.medicaresystemapi.db.entity.Patient
import pl.witex.medicaresystemapi.model.PersonName
import java.util.*

data class PatientResponse(
    val id: UUID,
    val name: PersonName,
    val address: String
)

fun PatientResponse.toEntity() =
    Patient().also {
        it.id = id
        it.address = address
        it.firstname = name.firstname
        it.surname = name.surname
    }