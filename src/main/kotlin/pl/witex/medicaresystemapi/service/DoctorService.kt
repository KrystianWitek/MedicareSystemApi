package pl.witex.medicaresystemapi.service

import org.springframework.stereotype.Component
import pl.witex.medicaresystemapi.db.repository.DoctorRepository
import pl.witex.medicaresystemapi.db.repository.PatientRepository
import pl.witex.medicaresystemapi.db.repository.VisitRepository

@Component
class DoctorService(
    private val repository: DoctorRepository
) {
    
}