package pl.witex.medicaresystemapi.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/visits")
class VisitsController {

    @GetMapping
    fun getAll() = "all"

    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID) = "one"

    @PostMapping
    fun add() = "addOne"

    @PutMapping
    fun update() = "updateOne"

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: UUID) = "deleteOne"
}