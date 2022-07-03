package fr.soumiabrk.patientapp.model

import com.google.gson.annotations.SerializedName

class User(
    val token: String,
    val id: Int,
    val username: String,
    @SerializedName(
        "first_name"
    ) val firstName: String,
    @SerializedName("last_name") val lastName: String,
    val email: String,
    @SerializedName(
        "user_type"
    ) val userType: String,
    val birthday: String,
    val gender: String,
)