package fr.soumiabrk.patientapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import fr.soumiabrk.patientapp.model.Vaccine
import fr.soumiabrk.patientapp.rest.RetrofitClient
import fr.soumiabrk.patientapp.service.VaccineService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VaccineFragment : Fragment() {
    private lateinit var nextButton: Button
    private lateinit var previousButton: Button
    private lateinit var skipButton: Button
    lateinit var radioGroup: RadioGroup

    private val vaccineService: VaccineService =
        RetrofitClient.client.create(VaccineService::class.java)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView = inflater.inflate(
            R.layout.fragment_vaccinefragment, container, false
        ) as ViewGroup

        nextButton = rootView.findViewById(R.id.nextbtn)
        previousButton = rootView.findViewById(R.id.backbtn)
        skipButton = rootView.findViewById(R.id.skipButton)
        radioGroup = rootView.findViewById<RadioGroup>(R.id.vaccinesGroup)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val hostActivity = (requireActivity() as AppointmentActivity)
        super.onViewCreated(view, savedInstanceState)
        nextButton.setOnClickListener {
            if (hostActivity.vaccine != null)
                hostActivity.next()
            else
                Toast.makeText(
                    requireContext(),
                    "Aucun vaccin n'a etait choisi",
                    Toast.LENGTH_SHORT
                ).show()
        }
        previousButton.setOnClickListener { _: View? -> (activity as AppointmentActivity?)!!.back() }
        skipButton.setOnClickListener {
            requireActivity().finish()
        }

        hostActivity.center?.vaccines?.forEach {
            val vaccineRadioButton =
                layoutInflater.inflate(
                    R.layout.vaccine_radio_button,
                    null
                ) as RadioButton

            vaccineRadioButton.text = it.vaccineName
            vaccineRadioButton.setOnClickListener { _ ->
                hostActivity.vaccine = it
            }

            radioGroup.addView(vaccineRadioButton)
        }
    }
}