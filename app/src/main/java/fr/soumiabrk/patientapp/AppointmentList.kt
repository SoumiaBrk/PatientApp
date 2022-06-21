package fr.soumiabrk.patientapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import fr.soumiabrk.patientapp.rest.RetrofitClient
import fr.soumiabrk.patientapp.service.AppointmentService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppointmentList : AppCompatActivity() {
    lateinit var floatingActionButton: FloatingActionButton
    lateinit var listappointement_image_profil: ImageView
    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    lateinit var appointmentList: MutableList<AppointmentListModel>
    lateinit var adapter: AdapterListAppointment
    private lateinit var NameListappointment: TextView

    private val appointmentService = RetrofitClient.client.create(AppointmentService::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment_list)
        listappointement_image_profil = findViewById(R.id.listappointement_image_profil)
        floatingActionButton = findViewById(R.id.floatingbutton)
        NameListappointment = findViewById(R.id.listAppointment_NameUser)
        val s = intent.getStringExtra(EditProfile.MSG)
        val tv = findViewById<TextView>(R.id.listAppointment_NameUser)
        tv.text = s

        listappointement_image_profil.setOnClickListener(View.OnClickListener {
            val i = Intent(this@AppointmentList, Profile::class.java)
            startActivity(i)
            finish()
        })
        floatingActionButton.setOnClickListener(View.OnClickListener {
            val i = Intent(this@AppointmentList, Appointment::class.java)
            startActivity(i)
            finish()
            Toast.makeText(this@AppointmentList, "Prendre un rendez-vous!", Toast.LENGTH_SHORT)
                .show()
        })
        initData()
        initRecyclerView()
    }

    private fun initData() {
        appointmentList = ArrayList()
        appointmentList.add(
            AppointmentListModel(
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi"
            )
        )
        appointmentList.add(
            AppointmentListModel(
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi"
            )
        )
        appointmentList.add(
            AppointmentListModel(
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi"
            )
        )
        appointmentList.add(
            AppointmentListModel(
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi"
            )
        )
    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerViewAppointment)
        appointmentService.getAppointments()
            .enqueue(object : Callback<List<fr.soumiabrk.patientapp.model.Appointment>> {
                override fun onResponse(
                    call: Call<List<fr.soumiabrk.patientapp.model.Appointment>>,
                    response: Response<List<fr.soumiabrk.patientapp.model.Appointment>>
                ) {
                    if (response.isSuccessful) {
                        if (response.body() != null) {
                            adapter = AdapterListAppointment(response.body()!!)
                            recyclerView.adapter = adapter
                        }
                    }
                }

                override fun onFailure(
                    call: Call<List<fr.soumiabrk.patientapp.model.Appointment>>,
                    t: Throwable
                ) {
                    t.printStackTrace()
                    Toast.makeText(applicationContext, "Erreur de chargement", Toast.LENGTH_SHORT)
                        .show()
                }

            })

    }
}