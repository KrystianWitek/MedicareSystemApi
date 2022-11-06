package pl.witex.medicaresystemapi.db.entity

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