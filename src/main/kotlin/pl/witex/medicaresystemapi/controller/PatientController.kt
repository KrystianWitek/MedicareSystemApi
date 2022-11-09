package pl.witex.medicaresystemapi.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.witex.medicaresystemapi.model.patient.Patient
import pl.witex.medicaresystemapi.service.PatientService
import java.util.*

@RestController
@RequestMapping("/patients")
class PatientController(
    private val service: PatientService
) {
    @GetMapping
    fun getAll(
        @RequestParam page: Int,
        @RequestParam size: Int
    ): List<Patient> = service.getAll(page, size)

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