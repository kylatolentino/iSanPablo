package com.app.isanpablo.ui.home.services

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.isanpablo.R
import com.app.isanpablo.databinding.HomeServicesBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class  ServicesFragment : Fragment() {

    private var _binding: HomeServicesBinding? = null
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
        _binding = HomeServicesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        updateTimeHandler.postDelayed(updateTimeRunnable, 0)

        // Shows the dialog box of the Hotline section
        binding.btnHotline.setOnClickListener {
            showhotline()
        }

        // Navigates to the Jobs and Business screens.
        binding.btnjobs.setOnClickListener {
            findNavController().navigate(R.id.nav_home_jobs)
        }
        binding.btnbusi.setOnClickListener {
            findNavController().navigate(R.id.nav_home_business)
        }

        // These buttons are the sub-menu of the Services section. It will navigate to the respective screens.
        binding.btnDisclosure.setOnClickListener {
            findNavController().navigate(R.id.nav_home_services_disclosure)
        }
        binding.btnOnlineGovService.setOnClickListener {
            findNavController().navigate(R.id.nav_home_services_onlinegovservice)
        }
        binding.btnCityEmployeeCorner.setOnClickListener {
            findNavController().navigate(R.id.nav_home_services_cityemployeecorner)
        }
        binding.btnEngineeringAndBuilding.setOnClickListener {
            findNavController().navigate(R.id.nav_home_services_engineeringandbuilding)
        }
        binding.btnTaxes.setOnClickListener {
            findNavController().navigate(R.id.nav_home_services_taxes)
        }
        binding.btnOnlineRequest.setOnClickListener {
            findNavController().navigate(R.id.nav_home_services_onlinerequest)
        }

        // The Philippine Registry for PWD and Bids and Awards buttons shows a confirmation dialog before directing to the respective links.
        binding.btnPWD.setOnClickListener {
            val link ="https://www.foi.gov.ph/login/?auth=false&next=/requests/how-to-register-to-doh-philippine-registry-for-persons-with-disability/"
            showConfirmationDialog(link)
        }
        binding.btnAwards.setOnClickListener {
            val link ="https://notices.philgeps.gov.ph/GEPSNONPILOT/Tender/SplashOpenOpportunitiesUI.aspx?ClickFrom=OpenOpp&menuIndex=3"
            showConfirmationDialog(link)
        }
        return root
    }
    private fun showConfirmationDialog(link:String) {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.confirmation_dialog)
        dialog.window?.setBackgroundDrawableResource(R.drawable.shape_rounded_dialog_border)
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
            showConfirmationDialog(link)
            dialog.dismiss()
        }
        dialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        updateTimeHandler.removeCallbacks(updateTimeRunnable)
    }
    private fun showhotline() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.city_hotline)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.setBackgroundDrawableResource(R.drawable.shape_rounded_dialog_border)

        val btnClose = dialog.findViewById<ImageView>(R.id.exitto) // assuming you have an ImageView with id "btnClose" in your layout
        btnClose.setOnClickListener {
            dialog.dismiss() // Close the dialog when the close button is clicked
        }

        // These allows the user to call the hotline number of each department or office of the city.
        // Initialize views inside the dialog layout
        val btnSpcGov = dialog.findViewById<ImageButton>(R.id.btnSpcGov)
        // Set click listener for the call button
        btnSpcGov.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numofSpcGov)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnOfficebuild = dialog.findViewById<ImageButton>(R.id.btnOfficebuild)
        // Set click listener for the call button
        btnOfficebuild.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numberOfOfficebuilding)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnassessor = dialog.findViewById<ImageButton>(R.id.btnassessor)
        // Set click listener for the call button
        btnassessor.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numberOfAssessor)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btntreasurer = dialog.findViewById<ImageButton>(R.id.btntreasurer)
        // Set click listener for the call button
        btntreasurer.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numberOfTreasurer)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnOfBusinessPermit = dialog.findViewById<ImageButton>(R.id.btnOfBusinessPermit)
        // Set click listener for the call button
        btnOfBusinessPermit.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numberOfBusinessPermit)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnOfBFP = dialog.findViewById<ImageButton>(R.id.btnOfBFP)
        // Set click listener for the call button
        btnOfBFP.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numberOfBFP)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnOfwelfareAndDev = dialog.findViewById<ImageButton>(R.id.btnOfwelfareAndDev)
        // Set click listener for the call button
        btnOfwelfareAndDev.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numberOfwelfareAndDev)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnOfRedCross = dialog.findViewById<ImageButton>(R.id.btnOfRedCross)
        // Set click listener for the call button
        btnOfRedCross.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numberOfRedCross)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnOfbrgyCont = dialog.findViewById<ImageButton>(R.id.btnOfbrgyCont)
        // Set click listener for the call button
        btnOfbrgyCont.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numberOfbrgyCont)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnOfSPCPACD = dialog.findViewById<ImageButton>(R.id.btnOfSPCPACD)
        // Set click listener for the call button
        btnOfSPCPACD.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numberOfSPCPACD)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnOfSPCPolice = dialog.findViewById<ImageButton>(R.id.btnOfSPCPolice)
        // Set click listener for the call button
        btnOfSPCPolice.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numberOfSPCPolice)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnOfSPCGenHos = dialog.findViewById<ImageButton>(R.id.btnOfSPCGenHos)
        // Set click listener for the call button
        btnOfSPCGenHos.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numberOfSPCGenHos)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnOfSPCcdrrmo = dialog.findViewById<ImageButton>(R.id.btnOfSPCcdrrmo)
        // Set click listener for the call button
        btnOfSPCcdrrmo.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numberOfSPCcdrrmo)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnsmartOfSPCcdrrmo = dialog.findViewById<ImageButton>(R.id.btnsmartOfSPCcdrrmo)
        // Set click listener for the call button
        btnsmartOfSPCcdrrmo.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.smartOfSPCcdrrmo)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnglobeOfSPCcdrrmo = dialog.findViewById<ImageButton>(R.id.btnglobeOfSPCcdrrmo)
        // Set click listener for the call button
        btnglobeOfSPCcdrrmo.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.globeOfSPCcdrrmo)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnOfSPCcho = dialog.findViewById<ImageButton>(R.id.btnOfSPCcho)
        // Set click listener for the call button
        btnOfSPCcho.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numberOfSPCcho)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnsmartOfSPCcho = dialog.findViewById<ImageButton>(R.id.btnsmartOfSPCcho)
        // Set click listener for the call button
        btnsmartOfSPCcho.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.smartOfSPCcho)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnglobeOfSPCcho = dialog.findViewById<ImageButton>(R.id.btnglobeOfSPCcho)
        // Set click listener for the call button
        btnglobeOfSPCcho.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.globeOfSPCcho)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }


        dialog.show()
    }

    // This function updates the clock every second.
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
