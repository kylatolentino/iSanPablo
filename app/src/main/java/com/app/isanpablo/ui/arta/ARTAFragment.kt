package com.app.isanpablo.ui.arta

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.app.isanpablo.R
import com.app.isanpablo.databinding.BlankpageBinding



class ARTAFragment : Fragment() {

    private var _binding: BlankpageBinding? = null
    private var link: String = " " // Initializing link variable

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    // Function to inflate the layout for this fragment
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflating the layout for this fragment using view binding
        _binding = BlankpageBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Show the dialog when fragment is created
        dialogEconomy()
        return root

    }

    // Function to show the dialog for ARTA options
    private fun dialogEconomy() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.fragment_arta)
        val exitButton: ImageView = dialog.findViewById(R.id.exitButton)

        // Retrieving buttons from the dialog layout
        val btnCitizenCharter: Button = dialog.findViewById(R.id.btnCitizenCharter)
        val btnChart: Button = dialog.findViewById(R.id.btnChart)

        // Setting background drawable for the dialog window
        dialog.window?.setBackgroundDrawableResource(R.drawable.shape_rounded_dialog_border)

        // Shows a confirmation dialog before navigating to the link
        btnCitizenCharter.setOnClickListener {
            link ="https://www.sanpablocity.gov.ph/docs/SPC_CC_2022.pdf"
            showConfirmationDialog(link)
        }
        // Shows a dialog box that says the Chart section in not yet available
        btnChart.setOnClickListener {
            showUnavailableDialog()
        }

        // Dismiss the dialog when exitButton is clicked
        exitButton.setOnClickListener {
            dialog.dismiss() // Dismiss the dialog
        }
        dialog.show() // Show the dialog
    }

    // Function to show confirmation dialog before navigating to the link
    private fun showConfirmationDialog(link: String) {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.confirmation_dialog)
        dialog.window?.setBackgroundDrawableResource(R.drawable.shape_rounded_dialog_border)
        val exitButton: Button = dialog.findViewById(R.id.btnCancel)
        val yesButton: Button = dialog.findViewById(R.id.btnOk)

        exitButton.setOnClickListener {
            dialog.dismiss() // Dismiss the dialog
        }

        // Navigate to the link when ok button is clicked
        yesButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }

        dialog.show()
    }

    // Function to show dialog when certain option is unavailable
    private fun showUnavailableDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.unavailable_dialog)
        dialog.window?.setBackgroundDrawableResource(R.drawable.shape_rounded_dialog_border)
        val exitButton: Button = dialog.findViewById(R.id.btnOk)

        // Dismiss the dialog when cancel button is clicked
        exitButton.setOnClickListener {
            dialog.dismiss() // Dismiss the dialog
        }
        dialog.show()
    }

    // Release binding when the fragment is destroyed
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}