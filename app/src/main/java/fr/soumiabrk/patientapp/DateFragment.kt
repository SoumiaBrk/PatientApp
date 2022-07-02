package fr.soumiabrk.patientapp

import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.*

class DateFragment : Fragment() {
    private var nextButton: Button? = null
    private var previousButton: Button? = null
    private var skipButton: Button? = null
    private lateinit var calendarview: CalendarView
    private var mydate: TextView? = null
    private val enregistrer: Button? = null
    private var buttonhour: Button? = null
    private var textHour: TextView? = null
    private var mHour = 0
    private var mMin = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView = inflater.inflate(
            R.layout.fragment_datefragment, container, false
        ) as ViewGroup
        buttonhour = rootView.findViewById(R.id.pick_time_button)
        textHour = rootView.findViewById(R.id.txtView_hour)
        nextButton = rootView.findViewById(R.id.nextbtn)
        previousButton = rootView.findViewById(R.id.backbtn)
        skipButton = rootView.findViewById(R.id.skipButton)
        calendarview = rootView.findViewById(R.id.date_calendar_DateAppointment)

        mydate = rootView.findViewById(R.id.myDate)
        val tomorrow = Calendar.getInstance()
        tomorrow.add(Calendar.DATE, 1)
        calendarview.minDate = tomorrow.timeInMillis

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val hostActivity = (requireActivity() as AppointmentActivity)
        nextButton!!.setOnClickListener {
            if (hostActivity.date != null && hostActivity.time != null)
                hostActivity.next()
            else
                Toast.makeText(
                    requireContext(),
                    "Vous devez selectionnez une date et heure",
                    Toast.LENGTH_SHORT
                ).show()
        }
        previousButton!!.setOnClickListener { (activity as AppointmentActivity?)!!.back() }

        buttonhour!!.setOnClickListener {
            val c = Calendar.getInstance()
            mHour = c[Calendar.HOUR_OF_DAY]
            mMin = c[Calendar.MINUTE]

            val timePickerDialog = TimePickerDialog(activity, { _, hourOfDay, minute ->
                val time = String.format(Locale.getDefault(), "%02d:%02d", hourOfDay, minute)
                textHour!!.text = time
                hostActivity.time = "$time"
                Log.d("*******", "time is : **** $time")
            }, mHour, mMin, false)
            timePickerDialog.show()
        }
        skipButton!!.setOnClickListener {
            val i = Intent(activity as AppointmentActivity?, AppointmentListActivity::class.java)
            startActivity(i)
        }
        calendarview.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val date = "$dayOfMonth/${(month + 1)}/$year"
            mydate!!.text = date

            hostActivity.date = "$year-${(month + 1)}-$dayOfMonth"
        }
    }
}