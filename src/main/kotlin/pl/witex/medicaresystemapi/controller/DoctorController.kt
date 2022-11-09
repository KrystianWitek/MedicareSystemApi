package pl.witex.medicaresystemapi.controller

import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.witex.medicaresystemapi.model.doctor.DoctorRequest
import pl.witex.medicaresystemapi.model.doctor.DoctorResponse
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
    ): Page<DoctorResponse> = service.getAll(page, size)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID): DoctorResponse = service.getById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun add(@RequestBody patient: DoctorRequest): UUID = service.add(patient)

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun update(@PathVariable id: UUID, @RequestBody patient: DoctorRequest) {
        service.update(id, patient)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: UUID) {
        service.delete(id)
    }
}