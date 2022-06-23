package fr.soumiabrk.patientapp

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.soumiabrk.patientapp.model.Center


class CentersListAdapter(
    private val centreList: List<Center>,
    val onItemCLickListener: (Int, Center) -> Unit
) :
    RecyclerView.Adapter<CentersListAdapter.ViewHolder>() {
    var selectedPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_design, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val center = centreList[position]
        holder.centerName.text = center.name
        holder.centerAddress.text = center.address
        holder.itemView.setOnClickListener {
            onItemCLickListener(position, center)
        }
        holder.selectedButton.isChecked = selectedPosition == position
        holder.addressButton.setOnClickListener {
            val intent =
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("geo:<${center.latitude}>,<${center.longitude}>?q=<${center.latitude}>,<${center.longitude}>(${center.name})")
                )
            holder.itemView.context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int {
        return centreList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val selectedButton: RadioButton
        val centerName: TextView
        val centerAddress: TextView
        val addressButton: Button
        private val divider: TextView


        init {
            selectedButton = itemView.findViewById(R.id.selectedButton)
            centerName = itemView.findViewById(R.id.centerName)
            centerAddress = itemView.findViewById(R.id.centerAddress)
            addressButton = itemView.findViewById(R.id.mapsButton)
            divider = itemView.findViewById(R.id.textview4)
        }
    }
}