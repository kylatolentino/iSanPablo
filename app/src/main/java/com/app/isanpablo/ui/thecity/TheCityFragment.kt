package com.app.isanpablo.ui.thecity

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.isanpablo.R
import com.app.isanpablo.databinding.FragmentThecityBinding

class TheCityFragment : Fragment() {

    private var _binding: FragmentThecityBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThecityBinding.inflate(inflater, container, false)

        // Shows dialog box that shows the mission statement
        binding.btnMission.setOnClickListener {
            val title = "Mission"
            val desc: String = "TO UPLIFT THE QUALITY OF THE LIFE OF SAN PABLEÑOS THROUGH " +
                    "EFFECTIVE AND EFFICEIENT DELIVERY OF PUBLIC SERVICE IN PARTNERSHIP WITH THE" +
                    " PRIVATE."
            showMissionDialogBox(title, desc)
        }

        // Navigates to the History page
        binding.btnHistory.setOnClickListener {
            findNavController().navigate(R.id.nav_thecity_history)
        }

        // Navigates to the Map page
        binding.btnmap2.setOnClickListener {
            findNavController().navigate(R.id.nav_government_map)
        }

        // Navigates to the Location and Topology page
        binding.btnGeLocation.setOnClickListener {
            findNavController().navigate(R.id.nav_thecity_locationtopology)
        }

        // Navigates to the San Pablo City page
        binding.btnSanpablo.setOnClickListener {
            findNavController().navigate(R.id.nav_thecity_plsp)
        }

        // Navigates to the Barangay page
        binding.btnBarangay.setOnClickListener {
            findNavController().navigate(R.id.nav_thecity_brgy)
        }

        // Shows dialog box that shows the vision statement
        binding.btnVision.setOnClickListener {
            val title = "Vision"
            val desc: String = "SAN PABLO, THE CITY OF SEVEN LAKES-PREMIER TOURIST " +
                    "DESTINATION, LIGHT INDUSTRIAL AND EDUCATION HUB IN CALABARZON, " +
                    "COMMITED TO GOOD GOVERNANCE AND SUSTAINABLE DEVELOPMENT."
            showMissionDialogBox(title, desc)
        }
        return binding.root
    }

    private fun showMissionDialogBox(title: String, desc:String) {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.thecity_visionmission_layout)
        val btnExit: ImageButton = dialog.findViewById(R.id.btnExit)
        dialog.window?.setBackgroundDrawableResource(R.drawable.shape_rounded_dialog_border)
        val dialogTitle = dialog.findViewById<TextView>(R.id.txtTitle)
        val dialogDescription = dialog.findViewById<TextView>(R.id.txtDesc)
        val dialogSubTitle = dialog.findViewById<TextView>(R.id.txtSubtitle)
        dialogTitle.text = title
        dialogDescription.text = desc
        dialogSubTitle.text = title

        btnExit.setOnClickListener {
            dialog.dismiss() // Dismiss the dialog
        }
        dialog.show() // Show the dialog
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}