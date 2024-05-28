package com.app.isanpablo.ui.government

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
import androidx.navigation.fragment.findNavController
import com.app.isanpablo.R
import com.app.isanpablo.databinding.FragmentGovernmentBinding
class GovernmentFragment : Fragment() {

    private var _binding: FragmentGovernmentBinding? = null
    private var link: String = ""
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGovernmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // The Standing Committees and Ordinance sections not yet available so the Unavailable dialog box is shown
        binding.btnStand.setOnClickListener {
            showUnavailableDialog()
        }
        binding.btnOrdinance.setOnClickListener {
            showUnavailableDialog()
        }
        binding.btnLocalOfficials.setOnClickListener {
            findNavController().navigate(R.id.nav_government_localofficial)
        }
        binding.btnDepartment.setOnClickListener {
            findNavController().navigate(R.id.nav_government_departments)
        }
        binding.btnMap.setOnClickListener {
            findNavController().navigate(R.id.nav_government_map)
        }

        // Shows a confirmation dialog if you want to access or download a pdf file of ELA
        binding.btnEla.setOnClickListener{
            link ="https://www.sanpablocity.gov.ph/docs/CDP%20Annexes%202018-2023.pdf"
            val dialog = Dialog(requireContext())
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.confirmation_dialog)
            val exitButton: Button = dialog.findViewById(R.id.btnCancel)
            dialog.window?.setBackgroundDrawableResource(R.drawable.shape_rounded_dialog_border)
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

        return root
    }

    // Function to show the unavailable dialog
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