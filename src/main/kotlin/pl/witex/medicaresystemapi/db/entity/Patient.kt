package pl.witex.medicaresystemapi.db.entity

import pl.witex.medicaresystemapi.model.PersonName
import pl.witex.medicaresystemapi.model.patient.PatientResponse
import javax.persistence.Column
import javax.persistence.Entity

@Entity
class Patient : ParentEntity() {

    @Column(nullable = false)
    lateinit var firstname: String

    @Column(nullable = false)
    lateinit var surname: String

    @Column(nullable = false)
    lateinit var address: String
}

fun Patient.toDto() =
    PatientResponse(
        id = id,
        name = PersonName(
            firstname = firstname,
            surname = surname
        ),
        address = address
    )