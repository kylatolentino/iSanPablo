package com.app.isanpablo.ui.departments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.isanpablo.R
import com.app.isanpablo.databinding.GovernmentDepartmentsBinding
import com.app.isanpablo.ui.government.GovernmentFragment


class DepartmentFragment : Fragment() {

    private var _binding: GovernmentDepartmentsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = GovernmentDepartmentsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.backButton.setOnClickListener{
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment_content_main, GovernmentFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}