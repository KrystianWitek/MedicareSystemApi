package pl.witex.medicaresystemapi.db.entity

import pl.witex.medicaresystemapi.model.Specialization
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated

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