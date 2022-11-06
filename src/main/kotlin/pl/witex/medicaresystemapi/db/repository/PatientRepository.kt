package pl.witex.medicaresystemapi.db.repository

import org.springframework.data.jpa.repository.JpaRepository
import pl.witex.medicaresystemapi.db.entity.Patient
import java.util.UUID

interface PatientRepository : JpaRepository<Patient, UUID>