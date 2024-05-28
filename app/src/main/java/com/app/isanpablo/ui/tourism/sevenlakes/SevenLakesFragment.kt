package com.app.isanpablo.ui.tourism.sevenlakes
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.app.isanpablo.R
import com.app.isanpablo.databinding.TourismLakesBinding



class SevenLakesFragment : Fragment() {

    private var _binding: TourismLakesBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = TourismLakesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Show the details of each lake
        binding.btnSampaloc.setOnClickListener {
            showPicDesc(
                "YAMBO Lake",
                "\u2022Nasasakupan: Barangay IV-A, IV-C, V-A, Concepcion, San Lucas 1\n" +
                        "\n\u2022Lawak: 99.21 Hectares\n" +
                        "\n\u2022Lalim: 27 Meters\n" +
                        "\n\u2022Yamang Lawa: Dalag, Hito,  Tilapia,Gurami, Hipon, " +
                        "Ayungin, Dulong, Big Head, Karpa, Bitoo, Kuhol\n" +
                        "\n\u2022Atrakson: Ang Lawa ng Sampalok, Sampalok Lake Mini " +
                        "Parks, Museo ng San Pablo, Doña Leonila Park, Hagdang Bato, Bonifacio " +
                        "Monument, Trese Martirez Monument "
            )
        }
        binding.btnBunot.setOnClickListener {
            showPicDesc(
                "BUNOT Lake",
                "\u2022Nasasakupan: Barangay Concepcion\n" +
                        "\n\u2022Lawak: 38.16 Hectares\n" +
                        "\n\u2022Lalim: 23 Meters\n" +
                        "\n\u2022Yamang Lawa: Dalag, Tilapia,Gurami, Hipon, Ayungin, Karpa, Bitoo, Kuhol\n" +
                        "\n\u2022Atrakson: Ang Lawa ng Bunot\n" +
                        "\n\u2022Mga Akomodasyon/Kainan: Cusina de Sabang 602, Bunot Lake Resort, Villa Muñoz Resort, Crisolaido’s Motorist Inn, NM Travellers Inn\n" +
                        "\n\u2022Tourist Arrivals: January 2019 – 1,824 | February 2019 – 2,358 | March 2019 – 2,160"
            )
        }
        binding.btnCalibato.setOnClickListener {
            showPicDesc(
                "CALIBATO Lake",
                "\u2022Nasasakupan: Barangay Sto. Angel\n" +
                        "\n\u2022Lawak: 27.18 Hectares\n" +
                        "\n\u2022Lalim: 135 Meters (pinakamalalim sa 7 lawa)\n" +
                        "\n\u2022Yamang Lawa: Dalag, Tilapia,Gurami, Hipon, Ayungin, Karpa, Bitoo, Kuhol, Big Head\n" +
                        "\n\u2022Atrakson: Ang Lawa ng Kalibato\n" +
                        "\n\u2022Tourist Arrivals: January 2019 – 47 | February 2019 – 239 | March 2019 - 74"
            )
        }
        binding.btnMohica.setOnClickListener {
            showPicDesc(
                "MOHICAP Lake",
                "\u2022Nasasakupan: Barangay San Buenaventura\n" +
                        "\n\u2022Lawak: 20.49 Hectares\n" +
                        "\n\u2022Lalim: 27 Meters\n" +
                        "\n\u2022Yamang Lawa: Dalag, Tilapia,Gurami, Hipon, Ayungin, Karpa, Bitoo, Kuhol\n" +
                        "\n\u2022Atrakson: Ang Lawa ng Muhikap, Boat Rafting with food service\n" +
                        "\n\u2022Mga Akomodasyon/Kainan: Star Lake Resort at Hotel\n" +
                        "\n\u2022Tourist Arrivals: January 2019 – 101 | February 2019 – 508 | March 2019 - 240"
            )
        }
        binding.btnPalakpakin.setOnClickListener {
            showPicDesc(
                "PALAKPAKIN Lake",
                "\u2022Nasasakupan: Barangay San Lorenzo, San Buenaventura, Dolores\n" +
                        "\n\u2022Lawak: 54.39 Hectares\n" +
                        "\n\u2022Lalim: 7.5 Meters\n" +
                        "\n\u2022Yamang Lawa: Dalag, Tilapia,Gurami, Hipon, Ayungin, Karpa, Bitoo, Kuhol, Aquarium Fish\n" +
                        "\n\u2022Atraksyon: Ang Lawa ng Palakpakin\n" +
                        "\n\u2022Tourist Arrivals: January 2019 – 26 | February 2019 – 246 | March 2019 - 53"
            )
        }
        binding.btnPandin.setOnClickListener {
            showPicDesc(
                "PANDIN Lake",
                "\u2022Nasasakupan: Barangay Sto. Angel, San Lorenzo\n" +
                        "\n\u2022Lawak: 23.54 Hectares\n" +
                        "\n\u2022Lalim: 63 Meters\n" +
                        "\n\u2022Yamang Lawa: Dalag, Tilapia,Gurami, Hipon, Ayungin, Karpa, Bitoo, Kuhol, Hito\n" +
                        "\n\u2022Atraksyon: Ang Lawa ng Pandin, Boat Rafting with food Services\n" +
                        "\n\u2022Tourist Arrivals: January 2019 – 2,647 | February 2019 – 2,905 | March 2019 – 5,651"
            )
        }
        binding.btnYambo.setOnClickListener {
            showPicDesc(
                "YAMBO Lake",
                "\u2022Nasasakupan: Barangay Sto. Angel, San Lorenzo\n" +
                        "\n\u2022Lawak: 36 Hectares\n" +
                        "\n\u2022Lalim: 40 Meters\n" +
                        "\n\u2022Yamang Lawa: Dalag, Tilapia,Gurami, Hipon, Ayungin, Karpa, Bitoo, Kuhol, Bakuli\n" +
                        "\n\u2022Atraksyon: Ang Lawa ng Yambo, Boat Rafting with food services\n" +
                        "\n\u2022Tourist Arrivals: January 2019 – 857 | February 2019 – 1,057 | March 2019 – 2,377"
            )
        }
        return root
    }
    private fun showPicDesc(title: String, description: String) {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.tourism_description)
        val dialogImageView = dialog.findViewById<ImageView>(R.id.imgView)
        val dialogTitle = dialog.findViewById<TextView>(R.id.txtTitle1)
        val dialogDescription = dialog.findViewById<TextView>(R.id.txtTitle)
        val exitButton: ImageView = dialog.findViewById(R.id.exitto)
        dialog.window?.setBackgroundDrawableResource(R.drawable.shape_rounded_dialog_border)
        dialogImageView.visibility = View.GONE
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