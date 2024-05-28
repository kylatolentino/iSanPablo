package com.app.isanpablo.ui.home.services.onlinerequest

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import androidx.fragment.app.Fragment
import com.app.isanpablo.R
import com.app.isanpablo.databinding.HomeServicesOnlinerequestBinding


class OnlineRequestFragment : Fragment() {

    private var _binding: HomeServicesOnlinerequestBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeServicesOnlinerequestBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // The button is for Request Copy of BPLO Fill-up Forma screen.
        binding.button222.setOnClickListener {
            showConfirmation()
        }

        // The button is for TD/ OHA screen.
        binding.btnTD.setOnClickListener {
            navigateToHomeServicesOha()
        }

        // The button is for Birth Certificate screen.
        binding.button42.setOnClickListener {
            navigateToBirthServices()
        }

        // The button is for Narriage Certificate screen.
        binding.button43.setOnClickListener {
            navigateToMarriageServices()
        }

        // The button is for Death Certificate screen.
        binding.button44.setOnClickListener {
            navigateToDeathServices()
        }

        return root
    }

    // It shows a dialog box when the buttons are clicked. These buttons are not yet available.
    private fun navigateToDeathServices() {
        showUnavailableDialog()
    }
    private fun navigateToMarriageServices() {
        showUnavailableDialog()
    }
    private fun navigateToBirthServices() {
        showUnavailableDialog()
    }
    private fun navigateToHomeServicesOha() {
        showUnavailableDialog()
    }
    private fun showConfirmation() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.home_services_request_bplo)
        dialog.window?.setBackgroundDrawableResource(R.drawable.shape_rounded_dialog_border)
        val exitButton: Button = dialog.findViewById(R.id.button146)
        val newBusiness: Button = dialog.findViewById(R.id.button143)
        val button144: Button = dialog.findViewById(R.id.button144)

        exitButton.setOnClickListener {
            dialog.dismiss() // Dismiss the dialog
        }
        newBusiness.setOnClickListener {
            showUnavailableDialog()
        }
        button144.setOnClickListener {
            showUnavailableDialog()
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
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
