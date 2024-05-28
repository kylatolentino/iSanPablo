package com.app.isanpablo.ui.home.announcement

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.app.isanpablo.R
import com.app.isanpablo.databinding.HomeAnnouncementBinding
class AnnouncementFragment : Fragment() {

    private var _binding: HomeAnnouncementBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeAnnouncementBinding.inflate(inflater, container, false)
        binding.btnimg1.setOnClickListener {

            // The picture, title, and description for each news item.
            showPicDesc(
                R.drawable.pic_news1,
                "SPC Events & Announcements",
                "BLESSING NG CITY TRANSPORT TERMINAL ISINAGAWA\n\nSetyembre 18, 2023- " +
                        "Pinasinayaan nina Mgsr. Jerry Bitoon, City Administrator Larry S. Amante, " +
                        "Vice-Mayor Justin G. Colago at mga miyembro ng Sangguniang Panglunsod, at " +
                        "City Terminal Manager Sigfred I. Palomar ang City Transport Terminal sa " +
                        "Brgy. San Rafael kaninang umaga, Setyembre 18, 2023. Ayon kay City " +
                        "Terminal Manager Palomar ito ay makakatulong sa pag-ganda ng daloy ng " +
                        "trapiko at sa ligtas na pagsakay ng mga pasahero na pangunahing layunin ni " +
                        "Mayor Vicente B. Amante. Nakiisa rin sa pagpapasinaya sina ABC President " +
                        "Ariston A. Amante, Executive Assistant Kristin A. Picazo at mga pinuno at " +
                        "pangalawang-pinuno ng iba’t-ibang tanggapan ng Lokal Na Pamahalaan."
            )
        }
        binding.btnimg2.setOnClickListener {
            showPicDesc(
                R.drawable.pic_news2,
                "SPC Events & Announcements",
                "854 BIKERS LUMAHOK SA 10KM FUN BIKE\n\nSeptember 18, 2023- Sa " +
                        "pangunguna ng mga organizers na sina Daren Suating at Ferdinand " +
                        "Vargas at pakikipagtulungan nina Vice-Gov. Karen Agapay, Emilio EG " +
                        "Garcia at Mayora Gem Castillo at ng City Tourism Office ay matagumpay" +
                        " na naisagawa kahapon ang 10KM Fun Bike, Ride Tayo Para Iwas Droga," +
                        " na nilahukan ng 854 bikers. Nagsimula ang bike run sa Bay, Laguna " +
                        "at nagtapos sa Sampalok Lake, San Pablo City. Nagwagi ng 1st place si " +
                        "Aron Alcala ng Sta. Cruz, Norte, Pila, Laguna; 2nd place si Erickson" +
                        " De Los Santos ng Cavinti, Laguna at 3rd place si Dhave Roa ng San Jose," +
                        " Batangas. Nagkamit ng P8,000 cash prize ang 1st, P4,000 ang 2nd at " +
                        "P2,000 ang 3rd"
            )
        }
        binding.btnimg3.setOnClickListener {
            showPicDesc(
                R.drawable.pic_news3,
                "SPC Events & Announcements",
                "PRIME-HRM MEMBERS BINIGYANG PAGKILALA SA PAGTATAAS NG WATAWAT\n\n" +
                        "Noong September 18, 2023, under the supervision of Concurrent " +
                        "CHRMO Diosdado A. Biglete at Human Resources Officer V. Elsa M. " +
                        "Ang mga organisasyon tulad ng HRM-PSB, PRAISE, HRDC, at SPMS ay " +
                        "nagbigay ng mga certificates of appreciation sa Barcelona para sa " +
                        "kanilang pakikilahok sa Watawat program at PRIME-HRM. Additionally," +
                        " HR Officer V Barcelona was honored for their participation in the" +
                        " 123rd Civil Service Month Celebration, as well as the Drug Summit," +
                        "Fun Run at Zumba 2023, and the Honorary Officer of the City Government."
            )
        }
        binding.btnimg4.setOnClickListener {
            showPicDesc(
                R.drawable.pic_news4,
                "SPC Events & Announcements",
                "Setyembre 5, 2023- Nagpulong kahapon sa City Disaster Office, Brgy. " +
                        "San Gregorio ang mga miyembro ng City Disaster Risk Reduction and " +
                        "Management Council\n\nUpang mapag-usapan at mapaghandaan ang isasagawang" +
                        " Regional Field Validation sa lunsod simula Setyembre 6, 2023. Ito ay" +
                        " para sa Gawad Kalasag 2023 na isang Seal and Special Awards for " +
                        "Excellence in Disaster Risk Reduction and Management. Pinag-usapan rin" +
                        " ang isasagawang National Simultaneous Earthquake Drill ng Pamahalaang" +
                        " Lunsod sa darating na Setyembre 7. Pinamunuan nina CDRRM Asst. Vanessa" +
                        " Reyes, CLGOO VI Maria Alma L. Barrientos, Councilor Carmela A. Acebedo," +
                        " Liga President Maning Amante at Executive Sec. to the Mayor Kristin A. " +
                        "Picazo ang nasabing pagpupulong."
            )
        }
        return binding.root
    }

    // A dialog box that contains a picture, title, and description when the image is clicked.
    private fun showPicDesc(imageResource: Int, title: String, description: String) {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.tourism_description)
        val dialogImageView = dialog.findViewById<ImageView>(R.id.imgView)
        val dialogTitle = dialog.findViewById<TextView>(R.id.txtTitle1)
        val dialogDescription = dialog.findViewById<TextView>(R.id.txtTitle)
        val exitButton: ImageView = dialog.findViewById(R.id.exitto)
        dialogImageView.setImageResource(imageResource)
        dialog.window?.setBackgroundDrawableResource(R.drawable.shape_rounded_dialog_border)
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