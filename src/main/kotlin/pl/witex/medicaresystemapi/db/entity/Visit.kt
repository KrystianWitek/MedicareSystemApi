package pl.witex.medicaresystemapi.db.entity

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

@Entity
class Visit : ParentEntity() {

    @Column(nullable = false)
    lateinit var date: LocalDateTime

    @Column(nullable = false)
    var hour: Int? = null

    @Column(nullable = false)
    lateinit var place: String

    @OneToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
    lateinit var doctor: Doctor

    @OneToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
    lateinit var patient: Patient
}