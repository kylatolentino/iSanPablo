package com.app.isanpablo.ui.home.services.engineeringandbuilding

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.app.isanpablo.R
import com.app.isanpablo.databinding.HomeServicesEngineeringandbuildingBinding

class HomeEngineeringAndBuildingFragment : Fragment() {

    private var _binding: HomeServicesEngineeringandbuildingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeServicesEngineeringandbuildingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // These are the menu of the Engineering and Building Form. It includes Engineering and Building Form, LCR Form, BPDL Form, RPT Request, HR Form and EBP System
        binding.button59.setOnClickListener {
            showConfirmationDialog()
        }

        // This button is not yet available.
        binding.button60.setOnClickListener {
            showUnavailableDialog()
        }

        // Allows downloading form once the user confirms it.
        binding.button61.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/BUSINESS%20PERMIT%20APPLICATION%20FORM.pdf"
            showdsialog(link)
        }

        // This button is not yet available.
        binding.button62.setOnClickListener {
            showUnavailableDialog()
        }

        // Shows a dialog box that contains the sub-menu of the HR section.
        binding.button63.setOnClickListener {
            showdhr()
        }

        // This section is not yet available.
        binding.button64.setOnClickListener {
            showUnavailableDialog()
        }
        return root
    }

    // Shows the sub-menu of HR Forms
    private fun showdhr() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.home_services_eabhr)
        dialog.window?.setBackgroundDrawableResource(R.drawable.shape_rounded_dialog_border)
        val exitButton: ImageButton = dialog.findViewById(R.id.HRExit)
        val newLeave: Button = dialog.findViewById(R.id.newLeave)
        val cOCEarned: Button = dialog.findViewById(R.id.COCEarned)
        val sALNForm: Button = dialog.findViewById(R.id.SALNForm)
        val pDSForm: Button = dialog.findViewById(R.id.PDSForm)
        val newlyHire: Button = dialog.findViewById(R.id.newlyHire)
        val promotion: Button = dialog.findViewById(R.id.Promotion)
        val hRClose: Button = dialog.findViewById(R.id.HRClose)
        exitButton.setOnClickListener {
            dialog.dismiss() // Dismiss the dialog
        }
        hRClose.setOnClickListener {
            dialog.dismiss() // Dismiss the dialog
        }

        // Contains the downloadable pdf files of the HR Forms.
        promotion.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/HR%20Forms/CHECKLIST%20OF%20REQUIREMENTS%20_PROMOTION_.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        newlyHire.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/HR%20Forms/CHECKLIST%20OF%20REQUIREMENTS%20_NEWLY%20HIRE_.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        pDSForm.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/HR%20Forms/PDS%20FORM.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        sALNForm.setOnClickListener {
            val link="https://www.sanpablocity.gov.ph/docs/HR%20Forms/SALN.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        cOCEarned.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/HR%20Forms/COC.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        newLeave.setOnClickListener {
            val link  ="https://www.sanpablocity.gov.ph/docs/HR%20Forms/LEAVE%20APPLICATION%20FORM.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }

        dialog.show()
    }
    private fun showdsialog(link:String) {
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
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun showUnavailableDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.unavailable_dialog)
        dialog.window?.setBackgroundDrawableResource(R.drawable.shape_rounded_dialog_border)
        val exitButton: Button = dialog.findViewById(R.id.btnOk)

        // Dismiss the dialog when cancel button is clicked
        exitButton.setOnClickListener {
            dialog.dismiss() // Dismiss the dialog
        }
        dialog.show()
    }

    // Shows the sub-menu of Engineering and Building Forms
    private fun showConfirmationDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.home_services_eabform)
        dialog.window?.setBackgroundDrawableResource(R.drawable.shape_rounded_dialog_border)
        val exitButton: ImageButton = dialog.findViewById(R.id.imageButton25)
        val applicationbuild: Button = dialog.findViewById(R.id.button66)
        val occupancy: Button = dialog.findViewById(R.id.button67)
        val ePermit: Button = dialog.findViewById(R.id.button68)
        val demolition: Button = dialog.findViewById(R.id.button69)
        val excavation: Button = dialog.findViewById(R.id.button70)
        val fencing: Button = dialog.findViewById(R.id.button71)
        val mechanical: Button = dialog.findViewById(R.id.button72)
        val scaffolding: Button = dialog.findViewById(R.id.button73)
        val sidewalk: Button = dialog.findViewById(R.id.button74)
        val connection: Button = dialog.findViewById(R.id.button80)
        val sign: Button = dialog.findViewById(R.id.button75)
        val tempsidewalk: Button = dialog.findViewById(R.id.button76)
        val termsandcond: Button = dialog.findViewById(R.id.button77)
        val close: Button = dialog.findViewById(R.id.button81)

        close.setOnClickListener {

            dialog.dismiss() // Dismiss the dialog
        }
        exitButton.setOnClickListener {

            dialog.dismiss() // Dismiss the dialog
        }

        // Contains the downloadable pdf files of the Engineering and Building Forms.
        termsandcond.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/OBO%20Forms/Terms%20and%20Conditions%20of%20Building%20Permit%20San%20Pablo%20City.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        tempsidewalk.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/OBO%20Forms/Temporary%20Sidewalk%20Enclosure%20San%20Pablo%20City.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        sign.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/OBO%20Forms/Sign%20Permit%20San%20Pablo%20City.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        connection.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/OBO%20Forms/Temporary%20Service%20Connection%20Permit%20San%20Pablo%20City.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        sidewalk.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/OBO%20Forms/Sidewalk%20Construction%20Permit%20San%20Pablo%20City.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        scaffolding.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/OBO%20Forms/Scaffolding%20Permit%20San%20Pablo%20City.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        mechanical.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/OBO%20Forms/Mechanical%20Permit%20San%20Pablo%20City.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        fencing.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/OBO%20Forms/Fencing%20Permit%20San%20Pablo%20City.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        excavation.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/OBO%20Forms/Excavation%20and%20Ground%20Preparation%20Permit%20San%20Pablo%20City.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        applicationbuild.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/OBO%20Forms/Application%20for%20Building%20Permit%20San%20Pablo%20City.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        occupancy.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/OBO%20Forms/Application%20for%20Certificate%20of%20Occupancy.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        ePermit.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/OBO%20Forms/Application%20for%20Electrical%20Permit%20San%20Pablo%20City.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        demolition.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/OBO%20Forms/Application%20for%20Electrical%20Permit%20San%20Pablo%20City.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }

        val checklist: Button = dialog.findViewById(R.id.button82)
        val annualinspect: Button = dialog.findViewById(R.id.button83)
        val reqdemo: Button = dialog.findViewById(R.id.button84)
        val reqEPermit: Button = dialog.findViewById(R.id.button85)
        val reqElectornic: Button = dialog.findViewById(R.id.button86)
        val reqExcavation: Button = dialog.findViewById(R.id.button87)
        val reqFencing: Button = dialog.findViewById(R.id.button88)
        val reqmechanical: Button = dialog.findViewById(R.id.button89)
        val reqPlumbing: Button = dialog.findViewById(R.id.button90)
        val reqScaffolding: Button = dialog.findViewById(R.id.button92)
        val reqsidwalk: Button = dialog.findViewById(R.id.button93)
        val reqSignpermit: Button = dialog.findViewById(R.id.button94)
        val reqConnection: Button = dialog.findViewById(R.id.button95)
        reqConnection.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/OBO%20Forms/requirements/Requirement%20of%20Temporary%20Service%20Connection%20Permit.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        reqSignpermit.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/OBO%20Forms/requirements/Requirement%20of%20Sign%20Permit.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        reqsidwalk.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/OBO%20Forms/requirements/Requirement%20of%20Sidewalk%20Construction%20Permit.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        reqScaffolding.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/OBO%20Forms/requirements/Requirement%20of%20Scaffolding%20Permit.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        reqPlumbing.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/OBO%20Forms/requirements/Requirement%20of%20Sanitary-Plumbing%20Permit.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        reqmechanical.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/OBO%20Forms/requirements/Requirement%20of%20Mechanical%20Permit.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        reqFencing.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/OBO%20Forms/requirements/Requirement%20of%20Fencing%20Permit.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        reqExcavation.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/OBO%20Forms/requirements/Requirement%20of%20Excavation%20and%20Ground%20Preparation%20Permit.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        reqElectornic.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/OBO%20Forms/requirements/Requirement%20of%20Electronics%20Permit.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        reqEPermit.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/OBO%20Forms/requirements/Requirement%20of%20Electrical%20Permit.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        reqdemo.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/OBO%20Forms/requirements/Requirement%20of%20Demolition%20Permit.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        annualinspect.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/OBO%20Forms/requirements/Requirement%20of%20Certificate%20of%20Annual%20Inspection%20Report%20for%20Business%20Permit.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }
        checklist.setOnClickListener {
            val link ="https://www.sanpablocity.gov.ph/docs/OBO%20Forms/requirements/Building%20Permit%20Checklist%20San%20Pablo%20City.pdf"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)
            dialog.dismiss()
        }

        dialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
