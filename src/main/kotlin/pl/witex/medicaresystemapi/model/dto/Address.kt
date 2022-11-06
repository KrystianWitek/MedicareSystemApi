package pl.witex.medicaresystemapi.model.dto

data class Address(
    val country: String,
    val city: String,
    val street: String,
    val houseNumber: String,
    val flatNumber: String?,
    val zip: String?
)