package pl.witex.medicaresystemapi

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pl.witex.medicaresystemapi.db.entity.Patient
import pl.witex.medicaresystemapi.db.repository.PatientRepository

class PatientSpec : BehaviorSpec({
    val repository: PatientRepository = mockk()

    given("In database in patient table exists rows") {
        val patient = Patient().apply {
            firstname = "Jan"
            surname = "Kowalski"
            address = "Wiejska 22"
        }

        every { repository.findAll() } returns listOf(patient)

        When("I want to get all patients") {
            val patients = withContext(Dispatchers.IO) {
                repository.findAll()
            }

            then("There should be only 1 patient") {
                patients.size.shouldBe(1)
            }
            then("There should be patient from Wiejska street") {
                patients.any { it.address.contains("Wiejska") }
            }
        }
    }
})