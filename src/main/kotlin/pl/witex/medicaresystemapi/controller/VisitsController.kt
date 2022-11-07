package pl.witex.medicaresystemapi.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.witex.medicaresystemapi.model.Visit
import pl.witex.medicaresystemapi.service.VisitService
import java.util.*

@RestController
@RequestMapping("/visits")
class VisitsController(
    private val service: VisitService
) {
    @GetMapping
    fun getAll(): List<Visit> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID): Visit = service.getById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun add(@RequestBody visit: Visit): UUID = service.add(visit)

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun update(@PathVariable id: UUID, @RequestBody visit: Visit) {
        service.update(id, visit)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: UUID) {
        service.delete(id)
    }
}