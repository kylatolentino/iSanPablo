package com.app.isanpablo.ui.home.business.doingbusiness.permitrenew

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.isanpablo.databinding.HomeBusinessDoingbusinessPermitrenewBinding

class PermitRenewFragment : Fragment() {

    private var _binding: HomeBusinessDoingbusinessPermitrenewBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeBusinessDoingbusinessPermitrenewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}
