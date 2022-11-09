package pl.witex.medicaresystemapi.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.witex.medicaresystemapi.model.visit.Visit
import pl.witex.medicaresystemapi.model.visit.VisitUpdate
import pl.witex.medicaresystemapi.service.VisitService
import java.util.*

@RestController
@RequestMapping("/visits")
class VisitsController(
    private val service: VisitService
) {
    @GetMapping("/patient/{id}")
    fun getAllByPatientId(
        @PathVariable id: UUID,
        @RequestParam page: Int,
        @RequestParam size: Int
    ): List<Visit> = service.getByPatientId(id, page, size)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody visit: Visit) {
        service.create(visit)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun update(@PathVariable id: UUID, @RequestBody visit: VisitUpdate) {
        service.updateHour(id, visit)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: UUID) {
        service.delete(id)
    }
}