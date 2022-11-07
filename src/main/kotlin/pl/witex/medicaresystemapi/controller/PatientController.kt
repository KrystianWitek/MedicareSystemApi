package pl.witex.medicaresystemapi.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import pl.witex.medicaresystemapi.model.patient.Patient
import pl.witex.medicaresystemapi.service.PatientService
import java.util.UUID

@RestController
@RequestMapping("/patients")
class PatientController(
    private val service: PatientService
) {
    @GetMapping
    fun getAll(): List<Patient> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID): Patient = service.getById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun add(@RequestBody patient: Patient): UUID = service.add(patient)

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun update(@PathVariable id: UUID, @RequestBody patient: Patient) {
        service.update(id, patient)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: UUID) {
        service.delete(id)
    }
}