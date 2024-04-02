package com.app.isanpablo.ui.government

import android.app.Dialog
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
import com.app.isanpablo.databinding.FragmentGovernmentBinding
import com.app.isanpablo.ui.localofficial.LocalOfficialFragment
import com.app.isanpablo.ui.departments.DepartmentFragment
import com.app.isanpablo.ui.ela.ElaFragment
import com.app.isanpablo.ui.map.MapFragment
class GovernmentFragment : Fragment() {

    private var _binding: FragmentGovernmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val governmentViewModel =
            ViewModelProvider(this).get(GovernmentViewModel::class.java)

        _binding = FragmentGovernmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.btnLocalOfficials.setOnClickListener{
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment_content_main,LocalOfficialFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.btnDepartment.setOnClickListener{
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment_content_main, DepartmentFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        binding.btnmap.setOnClickListener{
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment_content_main, MapFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        binding.btnstand.setOnClickListener {
            showUnavailableDialog()
        }
            binding.btnordinance.setOnClickListener {
            showUnavailableDialog()
        }

        binding.btnEla.setOnClickListener{
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
                val fragmentManager = requireActivity().supportFragmentManager
                val transaction = fragmentManager.beginTransaction()
                transaction.replace(R.id.nav_host_fragment_content_main,ElaFragment())
                transaction.addToBackStack(null)
                transaction.commit()
                dialog.dismiss()
            }
            dialog.show()

        }



        return root
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