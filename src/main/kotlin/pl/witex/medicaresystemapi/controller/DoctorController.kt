package pl.witex.medicaresystemapi.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.witex.medicaresystemapi.model.doctor.Doctor
import pl.witex.medicaresystemapi.service.DoctorService
import java.util.*

@RestController
@RequestMapping("/doctors")
class DoctorController(
    private val service: DoctorService
) {
    @GetMapping
    fun getAll(
        @RequestParam page: Int,
        @RequestParam size: Int
    ): List<Doctor> = service.getAll(page, size)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID): Doctor = service.getById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun add(@RequestBody patient: Doctor): UUID = service.add(patient)

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun update(@PathVariable id: UUID, @RequestBody patient: Doctor) {
        service.update(id, patient)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: UUID) {
        service.delete(id)
    }
}