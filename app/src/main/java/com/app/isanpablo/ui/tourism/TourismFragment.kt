package com.app.isanpablo.ui.tourism

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.isanpablo.R
import com.app.isanpablo.databinding.FragmentTourismBinding


class TourismFragment : Fragment() {

    private var _binding: FragmentTourismBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTourismBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Displays a dialog box that shows details and picture in tourism page
        binding.imPlaza.setOnClickListener {
            showPicDesc(
                R.drawable.pic_tourism_cityplaza,
                "The City Plaza",
                "•Rizal Monument was installed in 1911\n" +
                        "•Plaza fountain was constructed between 1916-1918 during the term of Don Feliano Exconde\n" +
                        "•Lamp posts in the plaza circle and islands along Rizal Ave. were erected by Mun. President Crispin Calabia (1928-1931)\n" +
                        "•The Mango Tree was believed to have been there since 1899."
            )
        }

        binding.imChruch.setOnClickListener {
            showPicDesc(
                R.drawable.pic_tourism_cathedral,
                "San Pablo Cathedral",
                "\t\tConstruction of the bricks and stones church started in 1680 and finished " +
                        "in 1721. The detailed affluent, ecclesiastical ornamentation were made by artist " +
                        "Juan de los Santos under Father Hernando Cabrera’s direction (1618-1629) who mandated " +
                        "that all payments and tributes to the church be made in the form of gold, silver and " +
                        "other metals. It was used as prison /garrison during the second world war by the " +
                        "invading Japanese forces between 1941-1945."
            )
        }
        binding.imFarcon.setOnClickListener {
            showPicDesc(
                R.drawable.pic_tourism_farcon,
                "Farcon Residence",
                "\t\tConstructed in the early 1950s. Design is a fusion of Hispanic and American-Colonial building styles. Home of Municipal President (1945) Don Alfonso Farcon."
            )
        }

        binding.imCityhall.setOnClickListener {
            showPicDesc(
                R.drawable.pic_tourism_cityhall,
                "San Pablo City Hall",
                "\t\tIt represents the prevailing architectural characteristics and design during the American Colonial period when the structure was built.\n" +
                        "The building was designed by Architect Antonio Toledo, one of the government Architects during the American Colonial period, show cases the popular design of the same period."
            )
        }
        binding.imhagdangbato.setOnClickListener {
            showPicDesc(
                R.drawable.pic_tourism_hagdangbato,
                "Hagdang Bato",
                "\t\tConstructed in 1915 under MP Marcial Alimario. It has five sections " +
                        "with a total of 89 steps. It serves as an access to Sampalok Lake from " +
                        "the view deck/Bonifacio Shrine. The lot was part of Dona Leonila Park " +
                        "which was donated by Cabesang Sixto Bautista."
            )
        }
        binding.imboni.setOnClickListener {
            showPicDesc(
                R.drawable.pic_tourism_boni,
                " Andres Bonifacio Monument",
                "\t\tThe Bonifacio monument is a reminder of the heroic deeds of Andres Bonifacio in the quest for Philippine Independence. It is strategically located at the upper west bank of Sampalok Lake, against a panoramic view of the lake from that view deck. It was inaugurated in November 30, 1997 in time for the hero’s 134th birth anniversary."
            )
        }
        binding.imroad.setOnClickListener {
            showPicDesc(
                R.drawable.pic_tourism_railroad,
                "Railroad Station",
                "\t\tThe coming of the railroad system to San Pablo City in 1908 revolutionized the transport of coconut- the city’s primary product, to Manila and ports where they are loaded and exported to various countries in the west and Europe, capitalizing on the high demand for coconut products abroad. This tremendously boosted the economy of San Pablo. In 1912, the Bureau of Public Works Publication mentioned that the most prosperous community in the Philippines was San Pablo (Juan B. Hernandez, San Pablo delos Montes"
            )
        }
        binding.imtrece.setOnClickListener {
            showPicDesc(
                R.drawable.pic_tourism_treceshrine,
                "Trece Martinez Shrine",
                " \t\tThe Trece Martires monument is a reminder of the martyrdom of the 13 Filipinos who were part of the quest for Philippine Independence. It is located at the intersection of a street which was named in their behalf."
            )
        }
        binding.imguerilla.setOnClickListener {
            showPicDesc(
                R.drawable.pic_tourism_guerilla,
                "Guerilla Shrine",
                " \t\tThe Battle of Mt. Kalisungan was the last Fil-Am uprising in the city of San Pablo against the Japanese Imperial Army in March 29, 1945. San Pablo City was finally liberated from the Japanese invaders on April 3, 1945 The battle of Mt. Kalisungan/WW II Memorial Shrine was inaugurated in August 27, 2000 to commemorate the event on the historic spot on March 29, 1945."
            )
        }
        binding.imdona.setOnClickListener {
            showPicDesc(
                R.drawable.pic_tourism_dona,
                " Doña Leonila Park",
                " \t\tDoña Leonila Park is the only park in the city today. Between 1968 to 1972, Mayor Cesar Dizon spearheaded the beautification of the park by installing the promenades, lake view deck and colonial lamp posts."
            )
        }
        binding.imlina.setOnClickListener {
            showPicDesc(
                R.drawable.pic_tourism_linabldg,
                "Lina Building",
                "\t\tThe Spanish Administration Building for Controlled Merchandise was constructed in 1814, of wood and light materials. It was burned in 1824 and was reconstructed the following year with stonewalls and tiled roofing under the supervision of Capitan Buenaventura de los Reyes with the assistance of church prior Apolinario Hernandez."
            )
        }
        binding.imfranklin.setOnClickListener {
            showPicDesc(
                R.drawable.pic_tourism_franklin,
                "Franklin Bakery Company",
                " \t\tFranklin Baker came to San Pablo (1922) under the name of Philippine Food Company, merged with Diehl Anderson Coconut Company. By 1923, Franklin Baker’s desiccated manufacturing and the Calamba Sugar Estate were competing for the premier industrial position in Laguna."
            )
        }
        binding.imcasa.setOnClickListener {
            showPicDesc(
                R.drawable.pic_tourism_casa,
                "Casa real / Old Building",
                "\t\tCasa Real was the first public building build by the Spanish friars in 1810 – 1814 under Father Cabrera; Rebuilt in 1905-1907 during the American regime under the supervision of the Philippine Commission."
            )
        }
        binding.immabini.setOnClickListener {
            showPicDesc(
                R.drawable.pic_tourism_mabini,
                "Apolinario Mabini Shrine",
                "\t\tThe Apolinario Mabini Shrine, the only one in the city of San Pablo and strategically located at the center island of the city main street is a reminder to everyone of the very important role that Apolinario Mabini played in the achievement of freedom and independence of the country from foreign invaders."
            )
        }
        binding.imprudencia.setOnClickListener {
            showPicDesc(
                R.drawable.pic_tourism_prudencia,
                " Prudencia Fule Acesstral Hous",
                " \t\tBuilt in the 1890s. This ancestral house was used as hide-out of General Miguel Malvar when he was in Laguna to confer with the Katipuneros in the late 1890s. The property was donated by the heirs of Ms. Prudencia Fule to the city government to be used for educational purposes only"
            )
        }
        binding.imcentral.setOnClickListener {
            showPicDesc(
                R.drawable.pic_tourism_central,
                "San Pablo Central School",
                "\t\tAs the first public school, the San Pablo Central School paved the way for the education of most San Pableños. Early professionals and local leaders were educated in the institution, under the American teachers."
            )
        }
        binding.btnFestAndEvent.setOnClickListener {
            findNavController().navigate(R.id.nav_tourism_festivalevent)
        }
        binding.btnSevenLakes.setOnClickListener {
            findNavController().navigate(R.id.nav_tourism_sevenlakes)
        }
        binding.btnGallery.setOnClickListener {
            findNavController().navigate(R.id.nav_tourism_gallery)
        }
        binding.btnTourism.setOnClickListener {
            showConfirmationDialog()
        }

        return root
    }

    // Displays a confirmation dialog before downloading the pdf file of Tourism Masterplan.
    private fun showConfirmationDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.confirmation_dialog)
        dialog.window?.setBackgroundDrawableResource(R.drawable.shape_rounded_dialog_border)
        val exitButton: Button = dialog.findViewById(R.id.btnCancel)
        val yesButton: Button = dialog.findViewById(R.id.btnOk)

        exitButton.setOnClickListener {
            dialog.dismiss() // Dismiss the dialog
        }

        yesButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.sanpablocity.gov.ph/docs/SP%20TMP.pdf"))
            startActivity(intent)
            dialog.dismiss()
        }

        dialog.show()
    }
    private fun showPicDesc(imageResource: Int, title: String, description: String) {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.tourism_description)
        val dialogImageView = dialog.findViewById<ImageView>(R.id.imgView)
        val dialogTitle = dialog.findViewById<TextView>(R.id.txtTitle)
        val dialogDescription = dialog.findViewById<TextView>(R.id.txtTitle)
        val exitButton: ImageView = dialog.findViewById(R.id.exitto)
        val dialogtxtTitle1 = dialog.findViewById<TextView>(R.id.txtTitle1)

        dialogImageView.setImageResource(imageResource)
        dialog.window?.setBackgroundDrawableResource(R.drawable.shape_rounded_dialog_border)
        dialogTitle.text = title
        dialogDescription.text = description
        dialogtxtTitle1.text = title
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
