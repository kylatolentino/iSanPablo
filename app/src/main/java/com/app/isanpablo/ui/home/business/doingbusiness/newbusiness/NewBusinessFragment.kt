package com.app.isanpablo.ui.home.business.doingbusiness.newbusiness

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.isanpablo.databinding.HomeBusinessDoingbusinessNewbusinessBinding

class NewBusinessFragment : Fragment() {

    private var _binding: HomeBusinessDoingbusinessNewbusinessBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeBusinessDoingbusinessNewbusinessBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}
