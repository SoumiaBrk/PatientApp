package fr.soumiabrk.patientapp.service

import fr.soumiabrk.patientapp.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Authentication {
    @POST("login/")
    fun login(@Body() body: Map<String, String>): Call<User>

}