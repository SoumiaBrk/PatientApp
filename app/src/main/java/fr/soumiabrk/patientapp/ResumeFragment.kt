package fr.soumiabrk.patientapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import fr.soumiabrk.patientapp.model.Appointment
import fr.soumiabrk.patientapp.rest.RetrofitClient
import fr.soumiabrk.patientapp.service.AppointmentService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResumeFragment : Fragment() {
    private lateinit var previousButton: Button
    private lateinit var skipButton: Button
    private lateinit var btn_confirm: Button

    private lateinit var dose: TextView
    private lateinit var centerText: TextView
    private lateinit var vaccineText: TextView
    private lateinit var dateText: TextView

    private var appointmentData: Map<String, Any?>? = null

    private val appointmentService: AppointmentService =
        RetrofitClient.client.create(AppointmentService::class.java)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView = inflater.inflate(
            R.layout.fragment_resume, container, false
        ) as ViewGroup
        previousButton = rootView.findViewById(R.id.backbtn)
        skipButton = rootView.findViewById(R.id.skipButton)
        btn_confirm = rootView.findViewById(R.id.btn_confirm)

        dose = rootView.findViewById(R.id.resumer_dose)
        centerText = rootView.findViewById(R.id.resumer_centre)
        vaccineText = rootView.findViewById(R.id.resumer_vaccin)
        dateText = rootView.findViewById(R.id.resumer_date)


        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        previousButton.setOnClickListener { v: View? -> (activity as AppointmentActivity?)!!.back() }

        skipButton.setOnClickListener {
            val i = Intent(activity as AppointmentActivity?, AppointmentListActivity::class.java)
            startActivity(i)
        }

        btn_confirm.setOnClickListener {
            appointmentService.createAppointment(appointmentData!!)
                .enqueue(object : Callback<Appointment> {
                    override fun onResponse(
                        call: Call<Appointment>,
                        response: Response<Appointment>
                    ) {
                        if (response.isSuccessful) {
                            if (response.body() != null) {
                                Toast.makeText(
                                    requireContext(),
                                    "Rendez vous créer avec succés",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            requireActivity().finish()
                        }
                    }

                    override fun onFailure(call: Call<Appointment>, t: Throwable) {
                        t.printStackTrace()
                        Toast.makeText(requireContext(), "Erreur serveur", Toast.LENGTH_SHORT)
                            .show()
                    }

                })
        }

    }

    override fun onResume() {
        super.onResume()
        appointmentData = (requireActivity() as AppointmentActivity).collectData()
        setUpTextViews(appointmentData!!)

    }

    private fun setUpTextViews(data_: Map<String, Any?>) {
        val hostActivity = (requireActivity() as AppointmentActivity)
        centerText.text = hostActivity.center?.name
        dose.text = hostActivity.dose.toString()
        vaccineText.text = hostActivity.vaccine?.vaccineName
        dateText.text = data_["appointment_date"].toString()

    }
}