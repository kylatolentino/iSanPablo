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
import androidx.lifecycle.ViewModelProvider
import com.app.isanpablo.R
import com.app.isanpablo.databinding.FragmentEconomyBinding



class ARTAFragment : Fragment() {

    private var _binding: FragmentEconomyBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val economyViewModel =
            ViewModelProvider(this).get(ARTAViewModel::class.java)

        _binding = FragmentEconomyBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val message: String = "Economy"
        dialogEconomy(message)
        return root

    }
    private fun dialogEconomy(message: String?) {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.fragment_arta)
        val exitButton: ImageView = dialog.findViewById(R.id.exitButton)
        val btnCitizenCharter: Button = dialog.findViewById(R.id.btnCitizenCharter)
        val btnChart: Button = dialog.findViewById(R.id.btnChart)
        dialog.window?.setBackgroundDrawableResource(R.drawable.rounded_dialog_bg)

        btnCitizenCharter.setOnClickListener {
            val link: String ="https://www.sanpablocity.gov.ph/docs/SPC_CC_2022.pdf"
            showConfirmationDialog(link)
        }
        btnChart.setOnClickListener {
            showUnavailableDialog()
        }

        exitButton.setOnClickListener {
            dialog.dismiss() // Dismiss the dialog
        }
        dialog.show() // Show the dialog
    }
    private fun showConfirmationDialog(link: String) {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.confirmation_downloadfile)
        val exitButton: Button = dialog.findViewById(R.id.btnCancel)
        val yesButton: Button = dialog.findViewById(R.id.btnOk)

        exitButton.setOnClickListener {
            dialog.dismiss() // Dismiss the dialog
        }

        yesButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }

        dialog.show()
    }
    private fun showUnavailableDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.government_ordinance)
        val exitButton: Button = dialog.findViewById(R.id.btnOk)
        exitButton.setOnClickListener {
            dialog.dismiss() // Dismiss the dialog
        }
        dialog.show()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}