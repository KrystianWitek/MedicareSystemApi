package pl.witex.medicaresystemapi.db.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import pl.witex.medicaresystemapi.db.entity.Visit
import java.util.*

interface VisitRepository : JpaRepository<Visit, UUID> {

    fun findAllByPatientId(patientId: UUID, pageable: Pageable): Page<Visit>
}