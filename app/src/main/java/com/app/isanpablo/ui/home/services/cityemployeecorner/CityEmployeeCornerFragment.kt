package com.app.isanpablo.ui.home.services.cityemployeecorner

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import androidx.fragment.app.Fragment
import com.app.isanpablo.R
import com.app.isanpablo.databinding.HomeServicesCityemployeecornerBinding

class CityEmployeeCornerFragment : Fragment() {

    private var _binding: HomeServicesCityemployeecornerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeServicesCityemployeecornerBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Buttons for Service Record, Copy of Payslip, and Vacation Leave. These buttons are not yet available.
        binding.imageButton28.setOnClickListener {
            showUnavailableDialog()
        }
        binding.imageButton29.setOnClickListener {
            showUnavailableDialog()
        }
        binding.imageButton30.setOnClickListener {
            showUnavailableDialog()
        }

        return root
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
