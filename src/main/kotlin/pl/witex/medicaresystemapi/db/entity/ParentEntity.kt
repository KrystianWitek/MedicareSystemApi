package pl.witex.medicaresystemapi.db.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class ParentEntity {

    @Id
    @Column(unique = true, updatable = false, insertable = false, columnDefinition = "uuid")
    open var id: UUID = UUID.randomUUID()
}