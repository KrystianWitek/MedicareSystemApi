package pl.witex.medicaresystemapi.model.patient

import pl.witex.medicaresystemapi.model.PersonName
import pl.witex.medicaresystemapi.db.entity.Patient as PatientEntity

data class Patient(
    val name: PersonName,
    val address: String // TODO jak wystarczy czasu to pobawić się w użycie Address
)

fun Patient.toEntity() =
    PatientEntity().also {
        it.address = address
        it.firstname = name.firstname
        it.surname = name.surname
    }