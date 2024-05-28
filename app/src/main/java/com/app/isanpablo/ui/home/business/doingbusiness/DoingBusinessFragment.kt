package com.app.isanpablo.ui.home.business.doingbusiness

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.isanpablo.R
import com.app.isanpablo.databinding.HomeBusinessDoingbusinessBinding



class DoingBusinessFragment : Fragment() {

    private var _binding: HomeBusinessDoingbusinessBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeBusinessDoingbusinessBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Directs to respective screens after the buttons are clicked. Here we can access the New Business Registration, Business Permit Renewal, and Tricycle Franchise and Permit for Tricycle Operators screens
        // Layout for New Business Registration = home_business_doingbusiness_newbusiness.xml
        // Layout for Business Permit Renewal = home_business_doingbusiness_permitrenew.xml
        // Layout for Tricycle Franchise and Permit for Tricycle Operators = home_business_doingbusiness_tric.xml

        binding.btnNewBusiness.setOnClickListener {
            findNavController().navigate(R.id.nav_home_business_doingbusiness_newbusiness)
        }
        binding.btnPermit.setOnClickListener {
            findNavController().navigate(R.id.nav_home_business_doingbusiness_permitrenew)
        }
        binding.btnTric.setOnClickListener {
            findNavController().navigate(R.id.nav_home_business_doingbusiness_tric)
        }


        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}
