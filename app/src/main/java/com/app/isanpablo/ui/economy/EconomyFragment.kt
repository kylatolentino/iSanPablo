package com.app.isanpablo.ui.economy

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
import androidx.navigation.fragment.findNavController

class EconomyFragment : Fragment() {

    //
    private var _binding: BlankpageBinding? = null
    private var link: String = ""

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

        dialogEconomy()
        return root

    }

    // Function to show the dialog containing economic options
    private fun dialogEconomy() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.fragment_economy)
        val exitButton: ImageView = dialog.findViewById(R.id.exitButton)

        // Retrieving buttons from the dialog layout
        val btnVolumeOne: Button = dialog.findViewById(R.id.btnVolumeOne)
        val btnVolumeTwo: Button = dialog.findViewById(R.id.btnVolumeTwo)
        val btnVolumeThree: Button = dialog.findViewById(R.id.btnVolumeThree)
        val btnCDP: Button = dialog.findViewById(R.id.btnCDP)
        val btnSpc: Button = dialog.findViewById(R.id.btnSpc)
        val btnCDPAnnexes: Button = dialog.findViewById(R.id.btnCDPAnnexes)

        // Setting background drawable for the dialog window
        dialog.window?.setBackgroundDrawableResource(R.drawable.shape_rounded_dialog_border)

        // It will show a confirmation dialog first before navigating to its respective link
        btnVolumeOne.setOnClickListener {
            link = "https://www.sanpablocity.gov.ph/docs/VOLUME%201%20The%20Comprehensive%20Land%20Use%20Plan%20San%20Pablo%20City%20as%20of%20Nov%2030%202016.pdf"
            showConfirmationDialog(link)
        }
        btnVolumeTwo.setOnClickListener {
            link = "https://www.sanpablocity.gov.ph/docs/VOLUME%202%20Zoning%20Ordinance%20San%20Pablo%20City%20as%20of%20Nov%2030%202016.pdf"
            showConfirmationDialog(link)
        }
        btnVolumeThree.setOnClickListener {
            link ="https://www.sanpablocity.gov.ph/docs/VOLUME%203%20Sectoral%20Studies%20San%20Pablo%20City%20UPDATED_as%20of%20Nov%2027%202016.pdf"
            showConfirmationDialog(link)
        }
        btnCDP.setOnClickListener {
            link ="https://www.sanpablocity.gov.ph/docs/CDP%20Annexes%202018-2023.pdf"
            showConfirmationDialog(link)
        }
        btnSpc.setOnClickListener {
            link ="https://www.sanpablocity.gov.ph/docs/SPC%20Ecological%20Profile.pdf"
            showConfirmationDialog(link)
        }
        btnCDPAnnexes.setOnClickListener {
            link ="https://www.sanpablocity.gov.ph/docs/CDP%20Annexes%202018-2023.pdf"
            showConfirmationDialog(link)
        }

        // Dismiss the dialog when exitButton is clicked
        exitButton.setOnClickListener {
            dialog.dismiss()
            // Dismiss the dialog
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
            dialog.dismiss()

        }

        // Navigate to the link when ok button is clicked
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