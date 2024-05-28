package com.app.isanpablo.ui.home.services.disclosure

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import androidx.fragment.app.Fragment
import com.app.isanpablo.R
import com.app.isanpablo.databinding.HomeServicesDisclosureBinding


class DisclosureFragment : Fragment() {

    private var _binding: HomeServicesDisclosureBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeServicesDisclosureBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Shows the confirmation dialog when the buttons are clicked. Those buttons allows users to download xlsx files.
        binding.disclosure1.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/Unliquidated-2018.xlsx"
            showConfirmationDialog(link)
        }
        binding.button176.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/Statement%20of%20Debt%20Services%2003.24.14.xlsx"
            showConfirmationDialog(link)
        }
        binding.disclosure2.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/SCF.xlsx"
            showConfirmationDialog(link)
        }
        binding.disclosure3.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/SFP.xlsx"
            showConfirmationDialog(link)
        }
        binding.disclosure4.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/SFPBS.xlsx"


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
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
