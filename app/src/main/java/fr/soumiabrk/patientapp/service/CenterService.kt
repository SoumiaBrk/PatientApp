package fr.soumiabrk.patientapp.service

import fr.soumiabrk.patientapp.model.Center
import retrofit2.Call
import retrofit2.http.GET

interface CenterService {

    @GET("center/")
    fun getAllCenters(): Call<Center>
}