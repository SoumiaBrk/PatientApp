package fr.soumiabrk.patientapp.service

import fr.soumiabrk.patientapp.model.Center
import fr.soumiabrk.patientapp.response.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface CenterService {

    @GET("center/")
    fun getAllCenters(): Call<List<Center>>
}