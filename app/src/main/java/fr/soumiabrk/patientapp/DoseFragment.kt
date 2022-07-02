package fr.soumiabrk.patientapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

class DoseFragment : Fragment() {
    private var nextButton: Button? = null
    private var previousButton: Button? = null
    private var skipButton: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView = inflater.inflate(R.layout.fragment_dose, container, false) as ViewGroup
        nextButton = rootView.findViewById(R.id.nextbtn)
        previousButton = rootView.findViewById(R.id.backbtn)
        skipButton = rootView.findViewById(R.id.skipButton)
        val radioGroup = rootView.findViewById<RadioGroup>(R.id.radioGroup)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioButton1 -> {
                    (requireActivity() as AppointmentActivity).dose = 1
                }
                R.id.radioButton2 -> {
                    (requireActivity() as AppointmentActivity).dose = 2
                }
                R.id.radioButton3 -> {
                    (requireActivity() as AppointmentActivity).dose = 3
                }
            }
        }
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
        nextButton!!.setOnClickListener {
            val hostActivity = (requireActivity() as AppointmentActivity)
            if (hostActivity.dose != 0)
                hostActivity.next()
            else
                Toast.makeText(
                    requireContext(),
                    "Aucune dose n'a etait choisi",
                    Toast.LENGTH_SHORT
                ).show()
        }
        previousButton!!.setOnClickListener { v: View? -> (activity as AppointmentActivity?)!!.back() }
        skipButton!!.setOnClickListener {
            val i = Intent(activity as AppointmentActivity?, AppointmentListActivity::class.java)
            startActivity(i)
        }
    }
}