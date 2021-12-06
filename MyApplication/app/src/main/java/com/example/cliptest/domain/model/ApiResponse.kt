package com.example.cliptest.domain.model
import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("results")
    val results: List<Result>? = null
)

data class Result(
    @SerializedName("cell")
    val cell: String? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("gender")
    val gender: String? = null,
    @SerializedName("location")
    val location: Location? = null,
    @SerializedName("login")
    val login: Login? = null,
    @SerializedName("name")
    val name: Name? = null,
    @SerializedName("phone")
    val phone: String? = null,
    @SerializedName("picture")
    val picture: Picture? = null,
    @SerializedName("registered")
    val registered: Registered? = null
)

data class Location(
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("coordinates")
    val coordinates: Coordinates? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("postcode")
    val postcode: String? = null,
    @SerializedName("state")
    val state: String? = null,
    @SerializedName("street")
    val street: Street? = null
)

data class Login(
    @SerializedName("username")
    val username: String? = null
)

data class Name(
    @SerializedName("first")
    val first: String? = null,
    @SerializedName("last")
    val last: String? = null
)

data class Picture(
    @SerializedName("large")
    val large: String? = null,
    @SerializedName("medium")
    val medium: String? = null,
    @SerializedName("thumbnail")
    val thumbnail: String? = null
)

data class Registered(
    @SerializedName("age")
    val age: String? = null,
    @SerializedName("date")
    val date: String? = null
)

data class Coordinates(
    @SerializedName("latitude")
    val latitude: String? = null,
    @SerializedName("longitude")
    val longitude: String? = null
)

data class Street(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("number")
        val number: String? = null
)
