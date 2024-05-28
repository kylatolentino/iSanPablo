package com.app.isanpablo.ui.tourism.gallery

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.app.isanpablo.R
import com.app.isanpablo.databinding.TourismGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: TourismGalleryBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = TourismGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Displays a dialog box with the image and title.
        binding.btnOldSpc.setOnClickListener {
            showPicDesc(
                R.drawable.pic_tourism_gallery_historyspc,
                "History Picture"
            )
        }
        binding.btnFarcon.setOnClickListener {
            showPicDesc(
                R.drawable.pic_tourism_gallery_farcon,
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
                R.drawable.pic_tourism_gallery_sampaloclake,
                "Sampaloc Lake"
            )
        }
        binding.btnCath.setOnClickListener {
            showPicDesc(
                R.drawable.pic_tourism_gallery_spcathedral,
                " Cathedral"
            )
        }
        binding.btnOldCath.setOnClickListener {
            showPicDesc(
                R.drawable.pic_tourism_gallery_oldcathedral,
                "Old Cathedral"
            )
        }
        binding.btnPlsp.setOnClickListener {
            showPicDesc(
                R.drawable.pic_tourism_gallery_plsp,
                "PLSP"
            )
        }
        binding.btnHagda.setOnClickListener {
            showPicDesc(
                R.drawable.pic_tourism_gallery_hagdangbato,
                "Hagdang Bato"
            )
        }

        return root
    }

    // Function to show the dialog box with the image and title.
    private fun showPicDesc(imageResource: Int, title: String ) {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.tourism_description)
        val dialogImageView = dialog.findViewById<ImageView>(R.id.imgView)
        val dialogTitle = dialog.findViewById<TextView>(R.id.txtTitle1)
        val dialogDescription = dialog.findViewById<TextView>(R.id.txtTitle)
        val exitButton: ImageView = dialog.findViewById(R.id.exitto)
        dialog.window?.setBackgroundDrawableResource(R.drawable.shape_rounded_dialog_border)
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