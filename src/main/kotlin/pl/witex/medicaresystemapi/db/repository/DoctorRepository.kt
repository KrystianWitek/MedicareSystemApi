package pl.witex.medicaresystemapi.db.repository

import org.springframework.data.jpa.repository.JpaRepository
import pl.witex.medicaresystemapi.db.entity.Doctor
import java.util.*

interface DoctorRepository : JpaRepository<Doctor, UUID>