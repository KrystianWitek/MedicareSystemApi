package pl.witex.medicaresystemapi.db.entity

import pl.witex.medicaresystemapi.model.PersonName
import pl.witex.medicaresystemapi.model.Specialization
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import pl.witex.medicaresystemapi.model.doctor.Doctor as DoctorDTO

@Entity
class Doctor : ParentEntity() {

    @Column(nullable = false)
    lateinit var firstname: String

    @Column(nullable = false)
    lateinit var surname: String

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    lateinit var specialization: Specialization
}

fun Doctor.toDto() =
    DoctorDTO(
        name = PersonName(firstname = firstname, surname = surname),
        specialization = specialization
    )