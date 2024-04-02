package com.app.isanpablo.ui.thecity

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.app.isanpablo.R
import com.app.isanpablo.databinding.FragmentThecityBinding
import com.app.isanpablo.ui.barangay.BarangayFragment
import com.app.isanpablo.ui.citysanpablenos.CitySanPablenosFragment
import com.app.isanpablo.ui.gelocation.GeLocationFragment
import com.app.isanpablo.ui.history.HistoryFragment
import com.app.isanpablo.ui.map.MapFragment

class TheCityFragment : Fragment() {

    private var _binding: FragmentThecityBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentThecityBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnVision.setOnClickListener {
            val message: String = "Vision"
            showCustomDialogBox(message)
        }
        binding.btnMission.setOnClickListener {
            val message: String = "Mission"
            showMissionDialogBox(message)
        }
        binding.btnHistory.setOnClickListener{
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment_content_main,HistoryFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.btnGeLocation.setOnClickListener{
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment_content_main, GeLocationFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.btnBarangay.setOnClickListener{
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment_content_main, BarangayFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.btnSanPablo.setOnClickListener{
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment_content_main, CitySanPablenosFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.btnmap2.setOnClickListener{
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment_content_main, MapFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        return root
    }
    private fun showCustomDialogBox(message: String?) {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.vision_dialog)
        val btnExit: ImageButton = dialog.findViewById(R.id.btnExit)
        dialog.window?.setBackgroundDrawableResource(R.drawable.rounded_dialog_bg)

        btnExit.setOnClickListener {
            dialog.dismiss() // Dismiss the dialog
        }
        dialog.show() // Show the dialog
    }
    private fun showMissionDialogBox(message: String?) {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.mission_dialog)
        val btnExitMission: ImageButton = dialog.findViewById(R.id.btnExitMission)
        dialog.window?.setBackgroundDrawableResource(R.drawable.rounded_dialog_bg)

        btnExitMission.setOnClickListener {
            dialog.dismiss() // Dismiss the dialog
            }
        dialog.show() // Show the dialog
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}