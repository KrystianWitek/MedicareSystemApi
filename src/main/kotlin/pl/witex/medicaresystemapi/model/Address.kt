package pl.witex.medicaresystemapi.model

data class Address(
    val country: String,
    val city: String,
    val street: String,
    val houseNumber: String,
    val flatNumber: String?,
    val zipCode: String? // TODO dodać beanValidation
) {
    fun getNormalizedAddress() = "$street $houseNumber/$flatNumber, $zipCode $city, $country"
}