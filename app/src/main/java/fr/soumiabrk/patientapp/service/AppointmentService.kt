package fr.soumiabrk.patientapp.service

import fr.soumiabrk.patientapp.model.Appointment
import fr.soumiabrk.patientapp.response.ApiResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AppointmentService {
    @GET("vaccination-appointment/{id}/")
    fun getAppointmentById(@Path("id") id: Long): Call<Appointment>

    @GET("vaccination-appointment/")
    fun getAppointments(): Call<List<Appointment>>


    @POST("vaccination-appointment/")
    fun createAppointment(@Body() appointment: Map<String, Any>): Call<Appointment>

}