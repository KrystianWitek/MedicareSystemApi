package pl.witex.medicaresystemapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class MedicareSystemApiApplication

fun main(args: Array<String>) {
    runApplication<MedicareSystemApiApplication>(*args)
}
