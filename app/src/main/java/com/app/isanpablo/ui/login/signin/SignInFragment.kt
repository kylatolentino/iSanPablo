package com.app.isanpablo.ui.login.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.isanpablo.R
import com.app.isanpablo.databinding.SignUpForm1Binding

class SignInFragment : Fragment() {

    private var _binding: SignUpForm1Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SignUpForm1Binding.inflate(inflater, container, false)

        // Navigates to the Login screen.
        binding.btnlogin2.setOnClickListener {
            findNavController().navigate(R.id.nav_login)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}