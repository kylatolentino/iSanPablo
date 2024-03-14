package com.app.isanpablo.ui.government

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.app.isanpablo.R
import com.app.isanpablo.databinding.FragmentGovernmentBinding
import com.app.isanpablo.ui.localofficial.LocalOfficialFragment

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


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}