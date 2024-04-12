package com.app.isanpablo.ui.homejobs

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.app.isanpablo.R
import com.app.isanpablo.databinding.HomeJobsMenuBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class HomeJobsFragment : Fragment() {

    private var _binding: HomeJobsMenuBinding? = null
    private val updateTimeRunnable = object : Runnable {
        override fun run() {
            updateClock()
            updateTimeHandler.postDelayed(this, 1000) // Update every second
        }
    }
    private val updateTimeHandler = Handler()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeJobsMenuBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupButtonClickListeners()

        updateTimeHandler.postDelayed(updateTimeRunnable, 0)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        updateTimeHandler.removeCallbacks(updateTimeRunnable)
    }

    private fun setupButtonClickListeners() {
        val buttons = listOf(
            Pair(binding.btnHR, "https://www.sanpabloca.gov/"),
            Pair(binding.btnCSC, "https://csc.gov.ph/career/"),
            Pair(binding.btnphilJob, "https://www.philjobnet.gov.ph/"),
            Pair(binding.btnPeso, "https://peso.gov.in/web/home")
        )

        buttons.forEach { (button, url) ->
            button.setOnClickListener {
                showConfirmationDialog(url)
            }
        }

        binding.imageView6.setOnClickListener {
            openExternalLink("https://www.pagasa.dost.gov.ph/")
        }
    }

    private fun showConfirmationDialog(url: String) {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.confirmation_downloadfile)
        val exitButton: Button = dialog.findViewById(R.id.btnCancel)
        val yesButton: Button = dialog.findViewById(R.id.btnOk)
        val textcontent: TextView = dialog.findViewById(R.id.textView490)
        val textTitle: TextView = dialog.findViewById(R.id.textView489)
        textTitle.text = "You’re leaving our app"
        textcontent.text =
            "The website you’re viewing is attempting to open an external app. Would you like to continue?"
        exitButton.setOnClickListener {
            dialog.dismiss() // Dismiss the dialog
        }
        yesButton.setOnClickListener {
            openExternalLink(url)
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun openExternalLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
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
