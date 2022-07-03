package fr.soumiabrk.patientapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.soumiabrk.patientapp.model.Appointment

class AdapterListAppointment(private val appointmentList: List<Appointment>) :
    RecyclerView.Adapter<AdapterListAppointment.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_apointment_design, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.time.text = appointmentList[position].appointmentDate.toLocaleString()
        holder.vaccin.text = appointmentList[position].vaccine.vaccineName
        holder.doctor_name2.text = appointmentList[position].doctor?.fullName ?: ""
        holder.qrCodeImage.setImageBitmap(getQrCodeBitmap(appointmentList[position].id.toString()))
        holder.appointmentStatus.text = when (appointmentList[position].status) {
            "PE" -> "En Attente"
            "CO" -> "Confirmé"
            "CA" -> "Annulé"
            "DO" -> "Effectué"
            else -> "NO"
        }
    }

    override fun getItemCount(): Int {
        return appointmentList!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //        val appointement_month: TextView
//        val appointement_day: TextView
//        val appointement_day_name: TextView
        val time: TextView
        val doctor_view_title: TextView
        val text_view_description2: TextView
        val appointmentStatus: TextView
        val vaccin: TextView
        val doctor_name2: TextView
        val qrCodeImage: ImageView


        init {
//            appointement_month = itemView.findViewById(R.id.appointement_month)
//            appointement_day = itemView.findViewById(R.id.appointement_day)
//            appointement_day_name = itemView.findViewById(R.id.appointement_day_name)
            time = itemView.findViewById(R.id.time)
            doctor_view_title = itemView.findViewById(R.id.doctor_view_title)
            text_view_description2 = itemView.findViewById(R.id.text_view_description2)
            appointmentStatus = itemView.findViewById(R.id.appointmentStatus)
            vaccin = itemView.findViewById(R.id.vaccin)
            doctor_name2 = itemView.findViewById(R.id.doctor_name2)
            qrCodeImage = itemView.findViewById(R.id.appointmentQrCode)
        }
    }
}