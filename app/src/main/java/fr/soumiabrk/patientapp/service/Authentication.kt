package fr.soumiabrk.patientapp.service

import fr.soumiabrk.patientapp.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Authentication {
    @POST("login/")
    fun login(@Body() body: Map<String, String>): Call<User>

    @POST("register/")
    @JvmSuppressWildcards
    fun register(@Body() body: Map<String, Any?>): Call<User>

    @GET("get-user/")
    fun getUser(): Call<User>

}