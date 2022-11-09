package pl.witex.medicaresystemapi.model.patient

import pl.witex.medicaresystemapi.model.PersonName
import pl.witex.medicaresystemapi.db.entity.Patient as PatientEntity

data class PatientRequest(
    val name: PersonName,
    val address: String
)

fun PatientRequest.toEntity() =
    PatientEntity().also {
        it.address = address
        it.firstname = name.firstname
        it.surname = name.surname
    }