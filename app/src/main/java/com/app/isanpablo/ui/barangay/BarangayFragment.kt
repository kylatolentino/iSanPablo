package com.app.isanpablo.ui.barangay

import android.app.Dialog
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.app.isanpablo.R
import com.app.isanpablo.databinding.DistrictBinding
import com.app.isanpablo.ui.thecity.TheCityFragment

class BarangayFragment : Fragment() {

    private var _binding: DistrictBinding? = null
    private val distict7 = arrayOf("District VII",
        "Barangay San Antonio I", "Barangay San Antonio II", "Barangay San " +
                "Francisco", "Barangay San Gregorio", "Barangay San Ignacio", "Barangay San Isidro",
        "Barangay San Joaquin", "Barangay San Jose", "Barangay San Vicente", "Barangay Sta. Ana",
                "Barangay Sta. Cruz", "Barangay Sto. Cristo")
    private val distict6 = arrayOf("District VI","Barangay San Gabriel","Barangay San Miguel","Barangay Sta. Maria",
        "Barangay Santisimo Rosario","Barangay Soledad")
    private val distict5 = arrayOf("District V","Barangay Del Remedio","Barangay San Crispin","Barangay San Juan",
        "Barangay San Lucas I","Barangay San Lucas II","Barangay San Marcos","Barangay San Mateo",
        "Barangay San Nicolas","Barangay San Refael","Barangay Sta. Felomena","Barangay Sta. Maria " +
                "Magdalena")
    private val distict4 = arrayOf("District IV","Barangay Bautista","Barangay San Bartolome","Barangay San Roque"
    ,"Barangay Sta. Monica","Barangay Sta. Veronica","Barangay Santiago I","Barangay Santiago II")
    private val distict3 = arrayOf("District III","Barangay San Cristobal","Barangay Sta. Elena","Barangay Sto. Nino")
    private val distict2 = arrayOf("District II","Barangay Concepcion","Barangay Dolores","Barangay San Buenaventura"
    ,"Barangay San Diego","Barangay San Lorenzo","Barangay San Pedro","Barangay" +
                " Sta. Catalina", "Barangay Sta. Isabel","Barangay Sto. Angel")
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DistrictBinding.inflate(inflater, container, false)
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
                when (position) {
                    1 -> {
                        showPicDesc(
                            "${distict7[position]}",
                            "REXON BANAAG",
                            "09088140375",
                            "35"
                        )
                        }
                    2 -> {
                        showPicDesc(
                            "${distict7[position]}",
                            "NOLIARCE0",
                            "09293049218",
                            "36"
                        )
                    }

                    3 -> {
                        showPicDesc(
                            "${distict7[position]}",
                            "ARNOLD",
                            "undefined",
                            "51"
                        )
                    }
                    4 -> {
                        showPicDesc(
                            "${distict7[position]}",
                            "ERWIN DE CASTRO",
                            "09652780178/09481256032",
                            "53"
                        )
                    }
                    5 -> {
                        showPicDesc(
                            "${distict7[position]}",
                            "HERNAN A. CALABIA",
                            "09052080598/ 530-7372",
                            "55"
                        )
                    }
                    6 -> {
                        showPicDesc(
                            "${distict7[position]}",
                            "JASMINE ALCANTARA",
                            "09108869874",
                            "56"
                        )
                    }
                    7 -> {
                        showPicDesc(
                            "${distict7[position]}",
                            "CRISTINA A. SAMSAMAN",
                            "09199627222",
                            "57"
                        )
                    }
                    8 -> {
                        showPicDesc(
                            "${distict7[position]}",
                            "ARISTON AMANTE",
                            "09998557375",
                            "58"
                        )
                    }
                    9 -> {
                        showPicDesc(
                            "${distict7[position]}",
                            "FREDERICK TOLENTINO",
                            "09071902405",
                            "79"
                        )
                    }
                    10-> {
                        showPicDesc(
                            "${distict7[position]}",
                            "LARRY ROSALES",
                            "09399537127",
                            "33"
                        )
                    }
                    11-> {
                        showPicDesc(
                            "${distict7[position]}",
                            "CIRILIO M. MOTAS",
                            "09072679032",
                            "45"
                        )
                    }
                    12-> {
                        showPicDesc(
                            "${distict7[position]}",
                            "RUBEN ARAMIL",
                            "09158315144",
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
                when (position) {
                    1 -> {
                        showPicDesc(
                            "${distict6[position]}",
                            "EFREN V. JANOLINO",
                            "09175228298",
                            "52"
                        )
                    }
                    2 -> {
                        showPicDesc(
                            "${distict6[position]}",
                            "JAIME",
                            "undefined",
                            "57"
                        )
                    }

                    3 -> {
                        showPicDesc(
                            "${distict6[position]}",
                            "JOEL B. QUINTO",
                            "09209755742",
                            "64"
                        )
                    }
                    4 -> {
                    showPicDesc(
                        "${distict6[position]}",
                        "ONOFRE ATIENZA",
                        "09217655597",
                        "74")
                    }
                    4 -> {
                        showPicDesc(
                            "${distict6[position]}",
                            "ONOFRE ATIENZA",
                            "09217655597",
                            "74"
                        )
                    }
                    5 -> {
                        showPicDesc(
                            "${distict6[position]}",
                            "Romeo E. Gonzales",
                            " ",
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
                    when (position) {
                        1 -> {
                            showPicDesc(
                                "${distict5[position]}",
                                "RONALDO D. REYES",
                                "09985500037",
                                "46",
                            )
                        }
                        2 -> {
                            showPicDesc(
                                "${distict5[position]}",
                                "ABNER DIONGLAY",
                                "09324563942",
                                "42",
                            )
                        }
                        3-> {
                            showPicDesc(
                                "${distict5[position]}",
                                "ANIANO H. BELDA",
                                "09193383043",
                                "59",
                            )
                        }
                        4-> {
                            showPicDesc(
                                "${distict5[position]}",
                                "ROMMEL E. CORDANO",
                                "09987916537",
                                "61",
                            )
                        }
                        5-> {
                            showPicDesc(
                                "${distict5[position]}",
                                "EUFRACUI L. CIABAL",
                                "09162607214/800-1498",
                                "62",
                            )
                        }
                        6-> {
                            showPicDesc(
                                "${distict5[position]}",
                                "ARIEL MAGCAWAS",
                                "09465856338/09502392796",
                                "63",
                            )
                        }
                        7-> {
                            showPicDesc(
                                "${distict5[position]}",
                                "RODELO C. ARCEO",
                                "09291415668",
                                "66",
                            )
                        }
                        8-> {
                            showPicDesc(
                                "${distict5[position]}",
                                "Barangay San Nicolas",
                                "9178593115",
                                "69",
                            )
                        }
                        9-> {
                            showPicDesc(
                                "${distict5[position]}",
                                "PLARIDEL DG.DELA CRUZ",
                                "09184794520/561-3526",
                                "72",
                            )
                        }
                        10-> {
                            showPicDesc(
                                "${distict5[position]}",
                                "ROLITO C. DEVANADERA",
                                "009266741225/ 503-0635",
                                "50",
                            )
                        }
                        11-> {
                            showPicDesc(
                                "${distict5[position]}",
                                "NECTOR BELEN",
                                "09491277010",
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
                when (position) {
                    1 -> {
                        showPicDesc(
                            "${distict4[position]}",
                            "LAMBERTO HERRERA",
                            "09198884506",
                            "38",
                        )
                    }
                    2 -> {
                        showPicDesc(
                            "${distict4[position]}",
                            "EXEQUIEL CARADA",
                            "5435621/09307221346",
                            "37",
                        )
                    }
                    3 -> {
                        showPicDesc(
                            "${distict4[position]}",
                            "TRECESUTO T. DIANGKINAY",
                            "09289090811",
                            "73",
                        )
                    }
                    4 -> {
                        showPicDesc(
                            "${distict4[position]}",
                            "MYRIN CASTANEDA",
                            "09999563267",
                            "68",
                        )
                    }
                    5 -> {
                        showPicDesc(
                            "${distict4[position]}",
                            "FELIX DANGUE",
                            "09398284976",
                            "78",
                        )
                    }
                    6 -> {
                        showPicDesc(
                            "${distict4[position]}",
                            "ARIEL M. DIANGKINAY",
                            "09289090811",
                            "75",
                        )
                    }
                    7 -> {
                        showPicDesc(
                            "${distict4[position]}",
                            "MARIO B. FLORES",
                            "09193138714",
                            "76",
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
                when (position) {
                    1 -> {
                        showPicDesc(
                            "${distict3[position]}",
                            "NECTOR BELEN",
                            "09491277010",
                            "65",
                        )
                    }
                    2 -> {
                        showPicDesc(
                            "${distict3[position]}",
                            "ARIEL CUENTAS",
                            "09289453273",
                            "49",
                        )
                    }
                    3 -> {
                        showPicDesc(
                            "${distict3[position]}",
                            "ARIEL BRIONES",
                            " 09973740052/09204226594",
                            "70",
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
                when (position) {
                    1 -> {
                        showPicDesc(
                            "${distict2[position]}",
                            "ERNESTO M.BANTING",
                            "09284598746/56-28179",
                            "41"
                        )
                    }
                    2 -> {
                        showPicDesc(
                            "${distict2[position]}",
                            "FRED F. ESPIRITU",
                            "09473671781 / 5730781",
                            "48"
                        )
                    }

                    3-> {
                        showPicDesc(
                            "${distict2[position]}",
                            "LEO BALDOVINO",
                            "09424941286",
                            "39"
                        )
                    }
                    4-> {
                        showPicDesc(
                            "${distict2[position]}",
                            "JERIC CAGUITE",
                            "09368584807",
                            "47"
                        )
                    }
                    5-> {
                        showPicDesc(
                            "${distict2[position]}",
                            "RONALDO R. FLORES",
                            "09991977500",
                            "60"
                        )
                    }
                    6   -> {
                        showPicDesc(
                            "${distict2[position]}",
                            "MACARIO P. ALMARIO",
                            "09193411705/800-1498",
                            "71"
                        )
                    }
                    7   -> {
                        showPicDesc(
                            "${distict2[position]}",
                            "ALDWIN C. ALCOS",
                            "099995746051/543-5593",
                            "40"
                        )
                    }
                    8  -> {
                        showPicDesc(
                            "${distict2[position]}",
                            "ALEX REYES",
                            "09128740518/094984875963",
                            "54"
                        )
                    }
                    9  -> {
                        showPicDesc(
                            "${distict2[position]}",
                            "CESARITO C. TICZON",
                            "09255230786",
                            "34"
                        )
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle when nothing is selected
            }
        }

        binding.btnBackBarangay.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment_content_main, TheCityFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        // Set custom spinner background when opened



        return root
    }
    private fun showPicDesc(title: String, chairMan: String, contact: String, brgy: String) {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.thecity_district_brgylayout)
        val dialogTitle = dialog.findViewById<TextView>(R.id.textBrgy)
        val dialogChairMan = dialog.findViewById<TextView>(R.id.txtChairMan)
        val dialogContact = dialog.findViewById<TextView>(R.id.txtContact)
        val dialogBrgy = dialog.findViewById<TextView>(R.id.txtCode)
        dialog.window?.setBackgroundDrawableResource(R.drawable.rounded_dialog_bg)
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
