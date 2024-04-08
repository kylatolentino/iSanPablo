package com.app.isanpablo.ui.gallery

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.app.isanpablo.R
import com.app.isanpablo.databinding.TourismGalleryBinding
import com.app.isanpablo.ui.tourism.TourismFragment

class GalleryFragment : Fragment() {

    private var _binding: TourismGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = TourismGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.back1.setOnClickListener{
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment_content_main, TourismFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        binding.btnOldSpc.setOnClickListener {
            showPicDesc(
                R.drawable.history_spc,
                "History Picture"
            )
        }
        binding.btnFarcon.setOnClickListener {
            showPicDesc(
                R.drawable.farcon,
                "Farcon Residence"
            )
        }
        binding.btnCityhall.setOnClickListener {
            showPicDesc(
                R.drawable.ic_government_mapl_oldcityhall,
                "Old City Hall"
            )
        }
        binding.btnSampa.setOnClickListener {
            showPicDesc(
                R.drawable.sampaloc_lake,
                "Sampaloc Lake"
            )
        }
        binding.btnCath.setOnClickListener {
            showPicDesc(
                R.drawable.spcathedral,
                " Cathedral"
            )
        }
        binding.btnOldCath.setOnClickListener {
            showPicDesc(
                R.drawable.old_cathedral,
                "Old Cathedral"
            )
        }
        binding.btnPlsp.setOnClickListener {
            showPicDesc(
                R.drawable.plsp,
                "PLSP"
            )
        }
        binding.btnHagda.setOnClickListener {
            showPicDesc(
                R.drawable.hagdangbato,
                "Hagdang Bato"
            )
        }

        return root
    }
    private fun showPicDesc(imageResource: Int, title: String ) {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.tourism_description)
        val dialogImageView = dialog.findViewById<ImageView>(R.id.imgView)
        val dialogTitle = dialog.findViewById<TextView>(R.id.txtTitle)
        val dialogDescription = dialog.findViewById<TextView>(R.id.txtdesc)
        val exitButton: ImageView = dialog.findViewById(R.id.exitto)
        dialogImageView.setImageResource(imageResource)
        dialogTitle.text = title
        dialogDescription.visibility = View.GONE
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