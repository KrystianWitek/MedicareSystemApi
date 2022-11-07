package pl.witex.medicaresystemapi.model.doctor

import pl.witex.medicaresystemapi.model.PersonName
import pl.witex.medicaresystemapi.model.Specialization
import pl.witex.medicaresystemapi.db.entity.Doctor as DoctorEntity

data class Doctor(
    val name: PersonName,
    val specialization: Specialization
)

fun Doctor.toEntity() =
    DoctorEntity().also {
        it.firstname = name.firstname
        it.surname = name.surname
        it.specialization = specialization
    }
