package fr.soumiabrk.patientapp

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.adapter.FragmentStateAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import fr.soumiabrk.patientapp.model.Center
import fr.soumiabrk.patientapp.model.Vaccine
import java.util.ArrayList

class AppointmentActivity : FragmentActivity() {
    private lateinit var viewPager: ViewPager2
    private var pagerAdapter: FragmentStateAdapter? = null

    var center: Center? = null
    var date: String? = null
    var time: String? = null
    var dose: Int = 0
    var vaccine: Vaccine? = null

    private val centerFragment = CenterFragment()
    private val doseFragment = DoseFragment()
    private val vaccineFragment = VaccineFragment()
    private val dateFragment = DateFragment()
    private val resumeFragment = ResumeFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment)

        // Instantiate a ViewPager2 and a PagerAdapter.
        viewPager = findViewById(R.id.pager)
        val fragments = ArrayList<Fragment>()
        fragments.add(centerFragment)
        fragments.add(doseFragment)
        fragments.add(vaccineFragment)
        fragments.add(dateFragment)
        fragments.add(resumeFragment)
        pagerAdapter = ScreenSlidePagerAdapter(this, fragments)
        viewPager.adapter = pagerAdapter
        viewPager.isUserInputEnabled = false
    }

    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }

    operator fun next() {
        viewPager.currentItem = viewPager.currentItem + 1
    }

    fun back() {
        viewPager.currentItem = viewPager.currentItem - 1
    }

    fun collectData(): Map<String, Any?> {
        Log.d("*******", "date it in activity: ****** $date")
        val data = mapOf<String, Any?>(
            "centre_id" to center?.id,
            "appointment_date" to "$date $time",
            "num_dose" to dose,
            "vaccine_id" to vaccine?.vaccine,
        )
        Log.d("***************", "collectData: $data")
        return data
    }

    private inner class ScreenSlidePagerAdapter(
        fa: FragmentActivity?,
        private val fragments: ArrayList<Fragment>
    ) : FragmentStateAdapter(
        fa!!
    ) {
        override fun createFragment(position: Int): Fragment {
            return fragments[position]
        }

        override fun getItemCount(): Int {
            return fragments.size
        }
    }


}