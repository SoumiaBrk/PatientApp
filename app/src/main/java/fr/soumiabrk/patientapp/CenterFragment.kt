package fr.soumiabrk.patientapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.soumiabrk.patientapp.model.Center
import fr.soumiabrk.patientapp.rest.RetrofitClient
import fr.soumiabrk.patientapp.service.CenterService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CenterFragment : Fragment() {
    private lateinit var nextButton: Button
    private lateinit var skipButton: Button
    lateinit var recyclerView: RecyclerView

    lateinit var adapter: CentersListAdapter

    private val centerService: CenterService =
        RetrofitClient.client.create(CenterService::class.java)

    private var selectedPosition = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView = inflater.inflate(R.layout.fragment_center, container, false) as ViewGroup
        nextButton = rootView.findViewById(R.id.nextbtn)
        skipButton = rootView.findViewById(R.id.skipButton)
        recyclerView = rootView.findViewById(R.id.recyclerView)

        initRecyclerView()
        return rootView
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = RecyclerView.VERTICAL
        recyclerView.layoutManager = layoutManager
        centerService.getAllCenters().enqueue(object : Callback<List<Center>> {
            override fun onResponse(
                call: Call<List<Center>>,
                response: Response<List<Center>>
            ) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        adapter =
                            CentersListAdapter(response.body()!!, this@CenterFragment::selectCenter)
                        recyclerView.adapter = adapter
                    }
                }
            }

            override fun onFailure(call: Call<List<Center>>, t: Throwable) {
                t.printStackTrace()
                Toast.makeText(context, "erreur de chargement", Toast.LENGTH_SHORT)
                    .show()
            }

        })
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nextButton.setOnClickListener {
            val hostActivity = (requireActivity() as AppointmentActivity)
            if (hostActivity.center != null)
                hostActivity.next()
            else
                Toast.makeText(
                    requireContext(),
                    "Aucun centre n'a etait choisi",
                    Toast.LENGTH_SHORT
                ).show()
        }
        skipButton.setOnClickListener {
            val i = Intent(activity as AppointmentActivity?, AppointmentListActivity::class.java)
            startActivity(i)
        }
    }


    fun selectCenter(position: Int, center: Center) {

        (requireActivity() as AppointmentActivity).center = center
        val oldPosition = adapter.selectedPosition

        adapter.selectedPosition = position
        adapter.notifyItemChanged(position)
        if (oldPosition != -1)
            adapter.notifyItemChanged(oldPosition)

    }
}