package pl.witex.medicaresystemapi.model.doctor

import pl.witex.medicaresystemapi.model.PersonName
import pl.witex.medicaresystemapi.model.Specialization
import pl.witex.medicaresystemapi.db.entity.Doctor as DoctorEntity

data class DoctorRequest(
    val name: PersonName,
    val specialization: Specialization
)

fun DoctorRequest.toEntity() =
    DoctorEntity().also {
        it.firstname = name.firstname
        it.surname = name.surname
        it.specialization = specialization
    }
