package com.app.isanpablo.ui.thecity.district

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.app.isanpablo.R
import com.app.isanpablo.databinding.ThecityDistrictBinding

class BarangayFragment : Fragment() {

    private var _binding: ThecityDistrictBinding? = null

    // Shows the district names in the spinner
    private val distict7 = arrayOf("District VII","Barangay Atisan",
        "Barangay San Antonio I", "Barangay San Antonio II", "Barangay San Francisco", "Barangay San Gregorio", "Barangay San Ignacio", "Barangay San Isidro",
        "Barangay San Joaquin", "Barangay San Jose", "Barangay San Vicente", "Barangay Sta. Ana",
        "Barangay Sta. Cruz", "Barangay Sto. Cristo")
    private val distict6 = arrayOf("District VI","Barangay San Gabriel","Barangay Sta. Maria", "Barangay San Miguel",
        "Barangay Santisimo Rosario","Barangay Soledad")
    private val distict5 = arrayOf("District V","Barangay Del Remedio","Barangay San Crispin","Barangay San Juan",
        "Barangay San Lucas I","Barangay San Lucas II","Barangay San Marcos","Barangay San Mateo",
        "Barangay San Nicolas","Barangay San Rafael","Barangay Sta. Filomena","Barangay Sta. Maria Magdalena")
    private val distict4 = arrayOf("District IV","Barangay Bautista","Barangay San Bartolome","Barangay San Roque"
        ,"Barangay Santiago I","Barangay Santiago II", "Barangay Sta. Monica","Barangay Sta. Veronica")
    private val distict3 = arrayOf("District III","Barangay San Cristobal","Barangay Sta. Elena","Barangay Sto. Nino")
    private val distict2 = arrayOf("District II","Barangay Concepcion","Barangay Dolores","Barangay San Buenaventura"
        ,"Barangay San Diego","Barangay San Lorenzo","Barangay San Pedro","Barangay" +
                " Sta. Catalina", "Barangay Sta. Isabel","Barangay Sto. Angel")
    private val distict1 = arrayOf("District I", "District I-A","Barangay Bagong Bayan (I-B)","Barangay I-C","Barangay II-A"
        ,"Barangay II-B","Barangay II-C","Barangay II-D","Barangay II-E","Barangay II-F","Barangay III-A"
        ,"Barangay III-B","Barangay III-C","Barangay III-D","Barangay III-E","Barangay III-F","Barangay IV-A"
        ,"Barangay IV-B","Barangay IV-C","Barangay V-A","Barangay V-B","Barangay V-C","Barangay V-D","Barangay VI-A"
        ,"Barangay VI-B","Barangay Bagong Pook (VI-C)","Barangay VI-D","Barangay VI-E","Barangay VII-A"
        ,"Barangay VII-B","Barangay VII-C","Barangay VII-D","Barangay VII-E")
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ThecityDistrictBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val spinner7 = binding.spinnerBrgy7
        val arrayAdapter7 = CustomSpinnerAdapter(requireContext(), distict7) // Instantiate your custom adapter
        spinner7.adapter = arrayAdapter7
        spinner7.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // Displays the details of each barangay that is under the district 7
                when (position) {
                    1 -> {
                        showPicDesc(
                            distict7[position],
                            "REYNANTE MANALO",
                            "503-4070",
                            ""
                        )
                    }
                    2 -> {
                        showPicDesc(
                            distict7[position],
                            "REXON U. BANAAG",
                            "808-0640",
                            "35"
                        )
                    }

                    3 -> {
                        showPicDesc(
                            distict7[position],
                            "ROMANO BELARMINO",
                            "",
                            "36"
                        )
                    }

                    4 -> {
                        showPicDesc(
                            distict7[position],
                            "DANDI C. MEDINA",
                            "831-7798",
                            "51"
                        )
                    }
                    5 -> {
                        showPicDesc(
                            distict7[position],
                            "RENE CALABIA",
                            "562-5641",
                            "53"
                        )
                    }

                    6 -> {
                        showPicDesc(
                            distict7[position],
                            "CRISANTO G. ALMARE",
                            "562-7372/ 530-7372",
                            "55"
                        )
                    }

                    7 -> {
                        showPicDesc(
                            distict7[position],
                            "NELSON CACAO",
                            "521-8583",
                            "56"
                        )
                    }

                    8 -> {
                        showPicDesc(
                            distict7[position],
                            "SILVERIO LAT",
                            "",
                            "57"
                        )
                    }

                    9 -> {
                        showPicDesc(
                            distict7[position],
                            "ARISTON A. AMANTE",
                            "503-6990",
                            "58"
                        )
                    }

                    10 -> {
                        showPicDesc(
                            distict7[position],
                            "FREDERICK TOLENTINO",
                            "808-4451",
                            "79"
                        )
                    }

                    11 -> {
                        showPicDesc(
                            distict7[position],
                            "JOEL A. OPULENCIA",
                            "501-2914",
                            "33"
                        )
                    }

                    12 -> {
                        showPicDesc(
                            distict7[position],
                            "CIRILO M. MOTAS",
                            "543-7935",
                            "45"
                        )
                    }

                    13 -> {
                        showPicDesc(
                            distict7[position],
                            "RUBEN ARAMIL",
                            "503-0575",
                            "43"
                        )
                    }

                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle when nothing is selected
            }
        }

        val spinner6 = binding.spinnerBrgy6
        val arrayAdapter6 = CustomSpinnerAdapter(requireContext(), distict6) // Instantiate your custom adapter
        spinner6.adapter = arrayAdapter6
        spinner6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // Displays the details of each barangay that is under the district 6
                when (position) {
                    1 -> {
                        showPicDesc(
                            distict6[position],
                            "MA. CALUDETTE J. AMANTE",
                            "559-9119",
                            "52"
                        )
                    }

                    2 -> {
                        showPicDesc(
                            distict6[position],
                            "RENATO BRION",
                            "503-2165",
                            "64"
                        )
                    }

                    3 -> {
                        showPicDesc(
                            distict6[position],
                            "ERICSON GUEVARRA",
                            "543-5403",
                            "57"
                        )
                    }

                    4 -> {
                        showPicDesc(
                            distict6[position],
                            "MAXIMO CASTILLO",
                            "808-3937",
                            "74")
                    }

                    5 -> {
                        showPicDesc(
                            distict6[position],
                            "TERESA GONZALES",
                            "521-8705",
                            "77"
                        )
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle when nothing is selected
            }
        }
        val spinner5 = binding.spinnerBrgy5
        val arrayAdapter5 = CustomSpinnerAdapter(requireContext(), distict5) // Instantiate your custom adapter
        spinner5.adapter = arrayAdapter5
        spinner5.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // Displays the details of each barangay that is under the district 5
                when (position) {
                    1 -> {
                        showPicDesc(
                            distict5[position],
                            "RONALDO D. REYES",
                            "557-0463",
                            "46",
                        )
                    }

                    2 -> {
                        showPicDesc(
                            distict5[position],
                            "ABNER DIONGLAY",
                            "562-9003",
                            "42",
                        )
                    }

                    3-> {
                        showPicDesc(
                            distict5[position],
                            "ANIANO H. BELDA",
                            "543-2325",
                            "59",
                        )
                    }

                    4-> {
                        showPicDesc(
                            distict5[position],
                            "ROMMEL E. CORDANO",
                            "503-4025",
                            "61",
                        )
                    }

                    5-> {
                        showPicDesc(
                            distict5[position],
                            "ROSALINDA ALCANTARA",
                            "800-1498",
                            "62",
                        )
                    }

                    6-> {
                        showPicDesc(
                            distict5[position],
                            "RECTO BELEN",
                            "09465856338/09502392796",
                            "63",
                        )
                    }

                    7-> {
                        showPicDesc(
                            distict5[position],
                            "JAIME FAJARDO",
                            "800-4347",
                            "66",
                        )
                    }

                    8-> {
                        showPicDesc(
                            distict5[position],
                            "BERNABE E. CUELLO",
                            "530-7728",
                            "69",
                        )
                    }

                    9-> {
                        showPicDesc(
                            distict5[position],
                            "HAROLD P. BELOY",
                            "561-3526",
                            "72",
                        )
                    }

                    10-> {
                        showPicDesc(
                            distict5[position],
                            "DORETEO TOLENTINO",
                            "546-2760",
                            "50",
                        )
                    }

                    11-> {
                        showPicDesc(
                            distict5[position],
                            "EVARISTO CAPUNO",
                            "530-6006",
                            "65",
                        )
                    }


                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle when nothing is selected
            }
        }


        val spinner4 = binding.spinnerBrgy4
        val arrayAdapter4 = CustomSpinnerAdapter(requireContext(), distict4) // Instantiate your custom adapter
        spinner4.adapter = arrayAdapter4
        spinner4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // Displays the details of each barangay that is under the district 4
                when (position) {
                    1 -> {
                        showPicDesc(
                            distict4[position],
                            "JOHN DARYL YOYONGCO",
                            "501-1251",
                            "38",
                        )
                    }

                    2 -> {
                        showPicDesc(
                            distict4[position],
                            "FERNANDO ATIENZA",
                            "523-6614/543-5621",
                            "37",
                        )
                    }

                    3 -> {
                        showPicDesc(
                            distict4[position],
                            "JOSE MARI B. LOPEZ",
                            "562-6766",
                            "73",
                        )
                    }

                    4 -> {
                        showPicDesc(
                            distict4[position],
                            "ARLENE D. REYES",
                            "539-4776",
                            "75",
                        )
                    }

                    5 -> {
                        showPicDesc(
                            distict4[position],
                            "MARIO B. FLORES",
                            "539-5200",
                            "76",
                        )
                    }

                    6 -> {
                        showPicDesc(
                            distict4[position],
                            "DANIEL ASEJO",
                            "800-3511",
                            "68",
                        )
                    }

                    7 -> {
                        showPicDesc(
                            distict4[position],
                            "FELIX DANGUE",
                            "",
                            "78",
                        )
                    }

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle when nothing is selected
            }
        }

        val spinner3 = binding.spinnerBrgy3
        val arrayAdapter3 = CustomSpinnerAdapter(requireContext(), distict3) // Instantiate your custom adapter
        spinner3.adapter = arrayAdapter3
        spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // Displays the details of each barangay that is under the district 3
                when (position) {
                    1 -> {
                        showPicDesc(
                            distict3[position],
                            "BENJAMIN M. FELISMINO II",
                            "523-6093",
                            "44",
                        )
                    }
                    2 -> {
                        showPicDesc(
                            distict3[position],
                            "ARIEL CUENTAS",
                            "543-6786",
                            "49",
                        )
                    }
                    3 -> {
                        showPicDesc(
                            distict3[position],
                            "HERMIE AMORAO",
                            "530-7556",
                            "70"
                        )
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle when nothing is selected
            }
        }


        val spinner2 = binding.spinnerBrgy2
        val arrayAdapter2 = CustomSpinnerAdapter(requireContext(), distict2) // Instantiate your custom adapter
        spinner2.adapter = arrayAdapter2
        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // Displays the details of each barangay that is under the district 2
                when (position) {
                    1  -> {
                        showPicDesc(
                            distict1[position],
                            "ELDRIN CARANDANG",
                            "562-8179",
                            "41"
                        )
                    }

                    2 -> {
                        showPicDesc(
                            distict2[position],
                            "NOMAR RIVERA",
                            "521-7509",
                            "48"
                        )
                    }

                    3-> {
                        showPicDesc(
                            distict2[position],
                            "JERRY Z. BRIZ",
                            "539-4460",
                            "39"
                        )
                    }
                    4-> {
                        showPicDesc(
                            distict2[position],
                            "JERIC CAGUITE",
                            "562-8983",
                            "47"
                        )
                    }

                    5-> {
                        showPicDesc(
                            distict2[position],
                            "ELMER TICZON",
                            "831-8915",
                            "60"
                        )
                    }

                    6   -> {
                        showPicDesc(
                            distict2[position],
                            "MICHAEL R. CAPUNO",
                            "562-2336",
                            "71"
                        )
                    }

                    7   -> {
                        showPicDesc(
                            distict2[position],
                            "DAMASO BRION",
                            "543-5593",
                            "40"
                        )
                    }

                    8  -> {
                        showPicDesc(
                            distict2[position],
                            "MC RENZ JOHN CABANCE",
                            "539-2689",
                            "54"
                        )
                    }

                    9  -> {
                        showPicDesc(
                            distict2[position],
                            "JOVITO MAGHIRANG",
                            "562-5154",
                            "34"
                        )
                    }

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle when nothing is selected
            }
        }

        val spinner1 = binding.spinnerBrgy1
        val arrayAdapter1 = CustomSpinnerAdapter(requireContext(), distict1) // Instantiate your custom adapter
        spinner1.adapter = arrayAdapter1

        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // Displays the details of each barangay that is under the district 1
                when (position) {
                    1 -> {
                        showPicDesc(
                            distict1[position],
                            "GERTRUDES PENALIN V. GALPAZ",
                            "",
                            ""
                        )
                    }
                    2 -> {
                        showPicDesc(
                            distict1[position],
                            "LUTHER LAGAYA",
                            "561-1472",
                            ""
                        )
                    }

                    3-> {
                        showPicDesc(
                            distict1[position],
                            "ROBBIE NARVAJA",
                            "562-6926",
                            ""
                        )
                    }
                    4-> {
                        showPicDesc(
                            distict1[position],
                            "RODELSON S. HIMOR",
                            "800-2831",
                            ""
                        )
                    }
                    5-> {
                        showPicDesc(
                            distict1[position],
                            "JOHN KRISTOFFER VILLANUEVA",
                            "",
                            ""
                        )
                    }
                    6   -> {
                        showPicDesc(
                            distict1[position],
                            "JOSEFINO E. MANICAD, JR.",
                            "",
                            ""
                        )
                    }
                    7   -> {
                        showPicDesc(
                            distict1[position],
                            "DAVID DHAVE GAMARA",
                            "503-2124",
                            ""
                        )
                    }
                    8  -> {
                        showPicDesc(
                            distict1[position],
                            "ROMNICK CYRUS G. MANALO",
                            "",
                            ""
                        )
                    }
                    9  -> {
                        showPicDesc(
                            distict1[position],
                            "GLENN ROY ESEO",
                            "503-7302",
                            ""
                        )
                    }

                    10  -> {
                        showPicDesc(
                            distict1[position],
                            "JOCELYN M. AVANZADO",
                            "545-9720",
                            ""
                        )
                    }

                    11  -> {
                        showPicDesc(
                            distict1[position],
                            "RUBEN T. PASCUA",
                            "503-5076",
                            ""
                        )
                    }

                    12-> {
                        showPicDesc(
                            distict1[position],
                            "JEFFERSON ENOBIO",
                            "559-7425",
                            ""
                        )
                    }

                    13  -> {
                        showPicDesc(
                            distict1[position],
                            "NORWIN DIMATULAC",
                            "808-3925",
                            ""
                        )
                    }

                    14  -> {
                        showPicDesc(
                            distict1[position],
                            "ARNOLD M. BRINAS",
                            "521-1659",
                            ""
                        )
                    }

                    15  -> {
                        showPicDesc(
                            distict1[position],
                            "ARNULFO G. ALVARAN",
                            "808-3556",
                            ""
                        )
                    }

                    16  -> {
                        showPicDesc(
                            distict1[position],
                            "JOSHUA COMIA",
                            "503-0222",
                            ""
                        )
                    }

                    17  -> {
                        showPicDesc(
                            distict1[position],
                            "RONALD ALLAN A. DE GALA",
                            "500-0834",
                            ""
                        )
                    }

                    18  -> {
                        showPicDesc(
                            distict1[position],
                            "APOLLO M. EMPEÑO",
                            "521-0679",
                            ""
                        )
                    }

                    19  -> {
                        showPicDesc(
                            distict1[position],
                            "RYAN L. MAGYAWE",
                            "543-2826",
                            ""
                        )
                    }

                    20  -> {
                        showPicDesc(
                            distict1[position],
                            "SUSAN E. BRIONES",
                            "545-2418",
                            ""
                        )
                    }

                    21  -> {
                        showPicDesc(
                            distict1[position],
                            "NOEL ENRIQUEZ",
                            "557-1022",
                            ""
                        )
                    }

                    22  -> {
                        showPicDesc(
                            distict1[position],
                            "JAN MICHAEL B. ALILIO",
                            "521-2120",
                            ""
                        )
                    }

                    23  -> {
                        showPicDesc(
                            distict1[position],
                            "RONALDO CASTILLO",
                            "562-4932",
                            ""
                        )
                    }

                    24  -> {
                        showPicDesc(
                            distict1[position],
                            "GERNAR P. AVINANTE",
                            "561-4256",
                            ""
                        )
                    }

                    25  -> {
                        showPicDesc(
                            distict1[position],
                            "ALEJANDRO D. VIDAL",
                            "",
                            ""
                        )
                    }

                    26  -> {
                        showPicDesc(
                            distict1[position],
                            "GENALYN B. MENDOZA",
                            "562-7967",
                            ""
                        )
                    }

                    27  -> {
                        showPicDesc(
                            distict1[position],
                            "DOMINADOR D. BELEN",
                            "561-1631/ 521-3784",
                            ""
                        )
                    }

                    28  -> {
                        showPicDesc(
                            distict1[position],
                            "GINA PUNDAN",
                            "561-2848",
                            ""
                        )
                    }

                    29  -> {
                        showPicDesc(
                            distict1[position],
                            "WILFRED BICOMONG",
                            "",
                            ""
                        )
                    }

                    30  -> {
                        showPicDesc(
                            distict1[position],
                            "TEODOLFO V. MARASIGAN",
                            "543-5561",
                            ""
                        )
                    }

                    31  -> {
                        showPicDesc(
                            distict1[position],
                            "GERRY CO",
                            "808-3558",
                            ""
                        )
                    }

                    32  -> {
                        showPicDesc(
                            distict1[position],
                            "VIVIAN LASTIMA",
                            "561-1631",
                            ""
                        )
                    }

                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle when nothing is selected
            }
        }

        // Set custom spinner background when opened



        return root
    }


    // Function for calling the details of the barangay
    private fun showPicDesc(title: String, chairMan: String, contact: String, brgy: String) {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.thecity_district_brgy)
        val dialogTitle = dialog.findViewById<TextView>(R.id.textBrgy)
        val dialogChairMan = dialog.findViewById<TextView>(R.id.txtChairMan)
        val dialogContact = dialog.findViewById<TextView>(R.id.txtContact)
        val dialogBrgy = dialog.findViewById<TextView>(R.id.txtCode)
        dialog.window?.setBackgroundDrawableResource(R.drawable.shape_rounded_dialog_border)
        dialogTitle.text = title
        dialogChairMan.text = chairMan
        dialogContact.text = contact
        dialogBrgy.text = brgy
        dialog.show()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
