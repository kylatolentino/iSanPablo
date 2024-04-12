package com.app.isanpablo.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.isanpablo.R
import com.app.isanpablo.databinding.FragmentHomeBinding
import com.app.isanpablo.ui.event.EventAndAnnouncementFragment
import com.app.isanpablo.ui.homejobs.HomeJobsFragment
import com.app.isanpablo.ui.tourism.TourismFragment
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val updateTimeRunnable = object : Runnable {
        override fun run() {
            updateClock()
            updateTimeHandler.postDelayed(this, 1000) // Update every second
        }
    }
    private val updateTimeHandler = Handler()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.imageView6.setOnClickListener {
            // Define the URL you want to open
            val url = "https://www.pagasa.dost.gov.ph/"

            // Create an Intent with the action ACTION_VIEW
            val intent = Intent(Intent.ACTION_VIEW)

            // Set the data of the Intent to the URL
            intent.data = Uri.parse(url)

            // Start the activity with the Intent
            startActivity(intent)
        }
        binding.btnViewSanPablo.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment_content_main, TourismFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.btnViewAllAnnounce.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment_content_main, EventAndAnnouncementFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.btnJobs.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment_content_main, HomeJobsFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        updateTimeHandler.postDelayed(updateTimeRunnable, 0)


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        updateTimeHandler.removeCallbacks(updateTimeRunnable)
    }
    private fun updateClock() {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("LLLL dd yyyy", Locale.getDefault())
        val timeFormat = SimpleDateFormat("hh:mm:ss a", Locale.getDefault())
        val dayFormat = SimpleDateFormat("EEEE", Locale.getDefault())

        val date = dateFormat.format(calendar.time)
        val time = timeFormat.format(calendar.time)
        val day = dayFormat.format(calendar.time)

        // Set date, time, and day to TextViews
        binding.textdate.text = date
        binding.texttime.text = time
        binding.textday.text = day
    }

}