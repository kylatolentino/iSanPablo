package com.app.isanpablo.ui.economy

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
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
        dialog.window?.setBackgroundDrawableResource(R.drawable.rounded_dialog_bg)
        exitButton.setOnClickListener {
            dialog.dismiss() // Dismiss the dialog
        }
        dialog.show() // Show the dialog
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}