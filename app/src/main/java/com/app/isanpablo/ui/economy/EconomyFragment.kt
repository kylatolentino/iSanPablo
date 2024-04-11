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
import androidx.lifecycle.ViewModelProvider
import com.app.isanpablo.R
import com.app.isanpablo.databinding.FragmentEconomyBinding




class EconomyFragment : Fragment() {

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
            ViewModelProvider(this).get(EconomyViewModel::class.java)


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
        dialog.setContentView(R.layout.economy_download)
        val exitButton: ImageView = dialog.findViewById(R.id.exitButton)
        val btnVolumeOne: Button = dialog.findViewById(R.id.btnVolumeOne)
        val btnVolumeTwo: Button = dialog.findViewById(R.id.btnVolumeTwo)
        val btnVolumeThree: Button = dialog.findViewById(R.id.btnVolumeThree)
        val btnCDP: Button = dialog.findViewById(R.id.btnCDP)
        val btnSpc: Button = dialog.findViewById(R.id.btnSpc)
        val btnCDPAnnexes: Button = dialog.findViewById(R.id.btnCDPAnnexes)
        dialog.window?.setBackgroundDrawableResource(R.drawable.rounded_dialog_bg)
        btnVolumeOne.setOnClickListener {
            val link: String = "https://www.sanpablocity.gov.ph/docs/VOLUME%201%20The%20Comprehensive%20Land%20Use%20Plan%20San%20Pablo%20City%20as%20of%20Nov%2030%202016.pdf"
            showConfirmationDialog(link)
        }
        btnVolumeTwo.setOnClickListener {
            val link: String = "https://www.sanpablocity.gov.ph/docs/VOLUME%202%20Zoning%20Ordinance%20San%20Pablo%20City%20as%20of%20Nov%2030%202016.pdf"
            showConfirmationDialog(link)
        }
        btnVolumeThree.setOnClickListener {
            val link: String ="https://www.sanpablocity.gov.ph/docs/VOLUME%203%20Sectoral%20Studies%20San%20Pablo%20City%20UPDATED_as%20of%20Nov%2027%202016.pdf"
            showConfirmationDialog(link)
        }
        btnCDP.setOnClickListener {
            val link: String ="https://www.sanpablocity.gov.ph/docs/CDP%20Annexes%202018-2023.pdf"
            showConfirmationDialog(link)
        }
        btnSpc.setOnClickListener {
            val link: String ="https://www.sanpablocity.gov.ph/docs/SPC%20Ecological%20Profile.pdf"
            showConfirmationDialog(link)
        }
        btnCDPAnnexes.setOnClickListener {
            val link: String ="https://www.sanpablocity.gov.ph/docs/CDP%20Annexes%202018-2023.pdf"
            showConfirmationDialog(link)
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
        dialog.window?.setBackgroundDrawableResource(R.drawable.rounded_dialog_bg)
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