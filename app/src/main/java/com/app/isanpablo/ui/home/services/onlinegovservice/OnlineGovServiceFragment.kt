package com.app.isanpablo.ui.home.services.onlinegovservice

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.system.Os.link
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.app.isanpablo.R
import com.app.isanpablo.databinding.HomeServiceOnlinegovBinding



class OnlineGovServiceFragment : Fragment() {

    private var _binding: HomeServiceOnlinegovBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeServiceOnlinegovBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Before it directs to the link, it shows a confirmation dialog when the user clicks on the button.
        binding.imageButton17.setOnClickListener {
            val link ="https://www.bir.gov.ph/"
            showConfirmationDialog(link)
        }
        binding.imageButton18.setOnClickListener {
            val link ="https://www.dti.gov.ph/"
            showConfirmationDialog(link)
        }
        binding.imageButton19.setOnClickListener {
            val link ="https://www.passport.gov.ph/"
            showConfirmationDialog(link)
        }
        binding.imageButton20.setOnClickListener {
            val link ="https://nbi.gov.ph/"
            showConfirmationDialog(link)
        }
        binding.imageButton21.setOnClickListener {
            val link ="https://www.sss.gov.ph/"
            showConfirmationDialog(link)
        }
        binding.imageButton22.setOnClickListener {
            val link ="https://philsys.gov.ph/"
            showConfirmationDialog(link)
        }
        binding.imageButton23.setOnClickListener {
            val link ="https://www.philhealth.gov.ph/"
            showConfirmationDialog(link)
        }
        binding.imageButton24.setOnClickListener {
            val link ="https://www.pagibigfund.gov.ph/"
            showConfirmationDialog(link)
        }

        return root
    }


    // A dialog box that asks the user if they want to leave the app and visit the link
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
    }
}
