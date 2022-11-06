package pl.witex.medicaresystemapi.service

import org.springframework.stereotype.Component
import pl.witex.medicaresystemapi.db.repository.PatientRepository

@Component
class PatientService(
    private val repository: PatientRepository
) {

}