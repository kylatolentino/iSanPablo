package com.app.isanpablo.ui.festandevent

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.app.isanpablo.R
import com.app.isanpablo.databinding.TourismFestivalEventBinding
import com.app.isanpablo.ui.tourism.TourismFragment

class FestivalAndEventFragment : Fragment() {

    private var _binding: TourismFestivalEventBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = TourismFestivalEventBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.back.setOnClickListener{
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment_content_main, TourismFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        binding.btnFestival.setOnClickListener {
            showPicDesc(
                R.drawable.cocofest,
                "Coco Festival ",
                "\tA week long festival celebrated every   week of January that showcases the rich cultural heritage and natural attractions."
            )
        }
        binding.btnTilapia.setOnClickListener {
            showPicDesc(
                R.drawable.tilapia,
                "Tilapia Festival",
                "\t Every 30th of May, San Pablo City celebrates the Tilapia Festival. It’s a festival for bountiful hearvest from the 7Lakes. Since 2005 this Festival Honors the Fishermen and their families with events like balsa regatta, balsa tug of war, Tilapia eating and Cooking contest"
            )
        }
        binding.btnMahal.setOnClickListener {
            showPicDesc(
                R.drawable.mahalnaaraw,
                "Lenten Season",
                "\t      The San Pablo City has a tradition that celebrates the Lenten Season highlight of Holy Week with Good Friday Procession. Life-size statues of Bible characters and scenes are mounted on lighted flower clad floats called “andas” escorted by believers while chanting prayers."
            )
        }
        binding.btnChristmas.setOnClickListener {
            showPicDesc(
                R.drawable.cristmas_lighting,
                "Cristmas tree Lightning",
                "The annual Lighting of Christmas tree at the City plaza of San Pablo every 1st day of December ushers the holiday season in the City. With the celebration comes the tradition of giving and sharing by the city government to less fortunate children and families of the city since 2008."

            )
        }


        return root
    }
    private fun showPicDesc(imageResource: Int, title: String, description: String ) {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.tourism_description)
        val dialogImageView = dialog.findViewById<ImageView>(R.id.imgView)
        val dialogTitle = dialog.findViewById<TextView>(R.id.txtTitle)
        val dialogDescription = dialog.findViewById<TextView>(R.id.txtdesc)
        val exitButton: ImageView = dialog.findViewById(R.id.exitto)
        dialogImageView.setImageResource(imageResource)
        dialogTitle.text = title
        dialogDescription.text = description
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