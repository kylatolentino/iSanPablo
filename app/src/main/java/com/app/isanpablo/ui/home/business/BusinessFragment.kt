package com.app.isanpablo.ui.home.business


import android.app.Dialog
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.isanpablo.R
import com.app.isanpablo.databinding.HomeBusinessBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class BusinessFragment : Fragment() {

    private var _binding: HomeBusinessBinding? = null
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
        updateTimeHandler.postDelayed(updateTimeRunnable, 0)
        _binding = HomeBusinessBinding.inflate(inflater, container, false)

        // Navigates to the Services and Jobs sections
        binding.btnServices.setOnClickListener{
            findNavController().navigate(R.id.nav_home_services)
        }
        binding.btnjobs.setOnClickListener{
            findNavController().navigate(R.id.nav_home_jobs)
        }

        // Navigates to the sub-menu of the Business section
        binding.btnDoingBusiness.setOnClickListener {
            findNavController().navigate(R.id.nav_home_business_doingbusiness)
        }

        // Shows a dialog box that says the Tax Payment and Investment sections are not yet available
        binding.btnTaxPayment.setOnClickListener {
            showUnavailableDialog()
        }
        binding.btnInvestment.setOnClickListener {
            showConfirmationDialog()
        }

        // Navigates to the sub-menu of the Business section
        binding.btnAmend.setOnClickListener {
            findNavController().navigate(R.id.nav_home_business_amend)
        }
        binding.btnMayorPermit.setOnClickListener {
            findNavController().navigate(R.id.nav_home_business_mayorpermit)
        }
        binding.btnBusinessTaxAssessment.setOnClickListener {
            findNavController().navigate(R.id.nav_home_business_taxassessment)
        }
        binding.btnMybusiness.setOnClickListener {
            findNavController().navigate(R.id.nav_home_business_mybusiness)
        }


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        updateTimeHandler.removeCallbacks(updateTimeRunnable)
    }

    // Shows a dialog box for Investment section. The dialog box contains two other options: "Why invest in San Pablo City?" and "Comprehensive Development Plan". These sections are not yet available
    private fun showConfirmationDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.home_business_investment)
        dialog.window?.setBackgroundDrawableResource(R.drawable.shape_rounded_dialog_border)
        val exitButton: Button = dialog.findViewById(R.id.btnCLose)
        val invest: Button = dialog.findViewById(R.id.btnInvest)
        val cdp: Button = dialog.findViewById(R.id.btnComp)
        exitButton.setOnClickListener {
            dialog.dismiss() // Dismiss the dialog
        }
        invest.setOnClickListener {
            showUnavailableDialog() // Dismiss the dialog
        }
        cdp.setOnClickListener {
            showUnavailableDialog() // Dismiss the dialog
        }


        dialog.show()
    }
    private fun showUnavailableDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.unavailable_dialog)
        dialog.window?.setBackgroundDrawableResource(R.drawable.shape_rounded_dialog_border)
        val exitButton: Button = dialog.findViewById(R.id.btnOk)
        exitButton.setOnClickListener {
            dialog.dismiss() // Dismiss the dialog
        }
        dialog.show()
    }

    // Function to update the clock
    private fun updateClock() {
        // Get current date and time
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