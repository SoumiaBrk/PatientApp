package fr.soumiabrk.patientapp.service

import fr.soumiabrk.patientapp.model.Vaccine
import retrofit2.Call
import retrofit2.http.GET

interface VaccineService {

    @GET("vaccine/")
    fun getAllVaccines(): Call<List<Vaccine>>
}