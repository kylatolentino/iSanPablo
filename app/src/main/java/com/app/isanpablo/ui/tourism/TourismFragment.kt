package com.app.isanpablo.ui.tourism

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.app.isanpablo.R
import com.app.isanpablo.databinding.FragmentTourismBinding

class TourismFragment : Fragment() {

    private var _binding: FragmentTourismBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTourismBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.imPlaza.setOnClickListener {
            showPicDesc(
                R.drawable.im_cityplaza,
                "The City Plaza",
                "• Rizal Monument was installed in 1911\n" +
                        "• Plaza fountain was constructed between 1916-1918 during the term of Don Feliano Exconde\n" +
                        "• Lamp posts in the plaza circle and islands along Rizal Ave. were erected by Mun. President Crispin Calabia (1928-1931)\n" +
                        "• The Mango Tree was believed to have been there since 1899."
            )
        }

        binding.imChruch.setOnClickListener {
            showPicDesc(
                R.drawable.im_cathedral,
                "San Pablo Cathedral",
                "Construction of the bricks and stones church started in 1680 and finished " +
                        "in 1721. The detailed affluent, ecclesiastical ornamentation were made by artist " +
                        "Juan de los Santos under Father Hernando Cabrera’s direction (1618-1629) who mandated " +
                        "that all payments and tributes to the church be made in the form of gold, silver and " +
                        "other metals. It was used as prison /garrison during the second world war by the " +
                        "invading Japanese forces between 1941-1945."
            )
        }
        binding.imFarcon.setOnClickListener {
            showPicDesc(
                R.drawable.im_farcon,
                "Farcon Residence",
                "Constructed in the early 1950s. Design is a fusion of Hispanic and American-Colonial building styles. Home of Municipal President (1945) Don Alfonso Farcon."
            )
        }

        binding.imCityhall.setOnClickListener {
            showPicDesc(
                R.drawable.im_cityhall,
                "San Pablo City Hall",
                "It represents the prevailing architectural characteristics and design during the American Colonial period when the structure was built.\n" +
                        "The building was designed by Architect Antonio Toledo, one of the government Architects during the American Colonial period, show cases the popular design of the same period."
            )
        }
        binding.imhagdangbato.setOnClickListener {
            showPicDesc(
                R.drawable.im_hagdangbato,
                "Hagdang Bato",
                "Constructed in 1915 under MP Marcial Alimario. It has five sections " +
                        "with a total of 89 steps. It serves as an access to Sampalok Lake from " +
                        "the view deck/Bonifacio Shrine. The lot was part of Dona Leonila Park " +
                        "which was donated by Cabesang Sixto Bautista."
            )
        }
        binding.imboni.setOnClickListener {
            showPicDesc(
                R.drawable.im_boni,
                " Andres Bonifacio Monument",
                "The Bonifacio monument is a reminder of the heroic deeds of Andres Bonifacio in the quest for Philippine Independence. It is strategically located at the upper west bank of Sampalok Lake, against a panoramic view of the lake from that view deck. It was inaugurated in November 30, 1997 in time for the hero’s 134th birth anniversary."
            )
        }
        binding.imroad.setOnClickListener {
            showPicDesc(
                R.drawable.im_railroad,
                "Railroad Station",
                "The coming of the railroad system to San Pablo City in 1908 revolutionized the transport of coconut- the city’s primary product, to Manila and ports where they are loaded and exported to various countries in the west and Europe, capitalizing on the high demand for coconut products abroad. This tremendously boosted the economy of San Pablo. In 1912, the Bureau of Public Works Publication mentioned that the most prosperous community in the Philippines was San Pablo (Juan B. Hernandez, San Pablo delos Montes"
            )
        }
        binding.imtrece.setOnClickListener {
            showPicDesc(
                R.drawable.im_hagdangbato,
                "Trece Martinez Shrine",
                " The Trece Martires monument is a reminder of the martyrdom of the 13 Filipinos who were part of the quest for Philippine Independence. It is located at the intersection of a street which was named in their behalf."
            )
        }
        binding.imguerilla.setOnClickListener {
            showPicDesc(
                R.drawable.im_hagdangbato,
                "Hagdang Bato",
                "Constructed in 1915 under MP Marcial Alimario. It has five sections " +
                        "with a total of 89 steps. It serves as an access to Sampalok Lake from " +
                        "the view deck/Bonifacio Shrine. The lot was part of Dona Leonila Park " +
                        "which was donated by Cabesang Sixto Bautista."
            )
        }
        return root
    }

    private fun showPicDesc(imageResource: Int, title: String, description: String) {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.tourism_description)
        val dialogImageView = dialog.findViewById<ImageView>(R.id.imgView)
        val dialogTitle = dialog.findViewById<TextView>(R.id.txtTitle)
        val dialogDescription = dialog.findViewById<TextView>(R.id.txtdesc)
        dialogImageView.setImageResource(imageResource)
        dialogTitle.text = title
        dialogDescription.text = description
        dialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
