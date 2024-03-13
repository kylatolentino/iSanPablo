package com.app.isanpablo

import android.Manifest
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.Window
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.app.isanpablo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            val message: String = "City Hotlines"
            showCustomDialogBox(message)
        }
        checkPermission()

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    private fun showCustomDialogBox(message: String?) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.city_hotline)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.setBackgroundDrawableResource(R.drawable.rounded_dialog_bg)

        val btnClose = dialog.findViewById<ImageView>(R.id.btnExitHotline) // assuming you have an ImageView with id "btnClose" in your layout
        btnClose.setOnClickListener {
            dialog.dismiss() // Close the dialog when the close button is clicked
        }

        // Initialize views inside the dialog layout
        val btnSpcGov = dialog.findViewById<ImageButton>(R.id.btnSpcGov)
        // Set click listener for the call button
        btnSpcGov.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numofSpcGov)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnOfficebuild = dialog.findViewById<ImageButton>(R.id.btnOfficebuild)
        // Set click listener for the call button
        btnOfficebuild.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numberOfOfficebuilding)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnassessor = dialog.findViewById<ImageButton>(R.id.btnassessor)
        // Set click listener for the call button
        btnassessor.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numberOfAssessor)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btntreasurer = dialog.findViewById<ImageButton>(R.id.btntreasurer)
        // Set click listener for the call button
        btntreasurer.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numberOfTreasurer)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnOfBusinessPermit = dialog.findViewById<ImageButton>(R.id.btnOfBusinessPermit)
        // Set click listener for the call button
        btnOfBusinessPermit.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numberOfBusinessPermit)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnOfBFP = dialog.findViewById<ImageButton>(R.id.btnOfBFP)
        // Set click listener for the call button
        btnOfBFP.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numberOfBFP)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnOfwelfareAndDev = dialog.findViewById<ImageButton>(R.id.btnOfwelfareAndDev)
        // Set click listener for the call button
        btnOfwelfareAndDev.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numberOfwelfareAndDev)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnOfRedCross = dialog.findViewById<ImageButton>(R.id.btnOfRedCross)
        // Set click listener for the call button
        btnOfRedCross.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numberOfRedCross)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnOfbrgyCont = dialog.findViewById<ImageButton>(R.id.btnOfbrgyCont)
        // Set click listener for the call button
        btnOfbrgyCont.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numberOfbrgyCont)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnOfSPCPACD = dialog.findViewById<ImageButton>(R.id.btnOfSPCPACD)
        // Set click listener for the call button
        btnOfSPCPACD.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numberOfSPCPACD)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnOfSPCPolice = dialog.findViewById<ImageButton>(R.id.btnOfSPCPolice)
        // Set click listener for the call button
        btnOfSPCPolice.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numberOfSPCPolice)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnOfSPCGenHos = dialog.findViewById<ImageButton>(R.id.btnOfSPCGenHos)
        // Set click listener for the call button
        btnOfSPCGenHos.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numberOfSPCGenHos)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnOfSPCcdrrmo = dialog.findViewById<ImageButton>(R.id.btnOfSPCcdrrmo)
        // Set click listener for the call button
        btnOfSPCcdrrmo.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numberOfSPCcdrrmo)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnsmartOfSPCcdrrmo = dialog.findViewById<ImageButton>(R.id.btnsmartOfSPCcdrrmo)
        // Set click listener for the call button
        btnsmartOfSPCcdrrmo.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.smartOfSPCcdrrmo)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnglobeOfSPCcdrrmo = dialog.findViewById<ImageButton>(R.id.btnglobeOfSPCcdrrmo)
        // Set click listener for the call button
        btnglobeOfSPCcdrrmo.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.globeOfSPCcdrrmo)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnOfSPCcho = dialog.findViewById<ImageButton>(R.id.btnOfSPCcho)
        // Set click listener for the call button
        btnOfSPCcho.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.numberOfSPCcho)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnsmartOfSPCcho = dialog.findViewById<ImageButton>(R.id.btnsmartOfSPCcho)
        // Set click listener for the call button
        btnsmartOfSPCcho.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.smartOfSPCcho)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }
        val btnglobeOfSPCcho = dialog.findViewById<ImageButton>(R.id.btnglobeOfSPCcho)
        // Set click listener for the call button
        btnglobeOfSPCcho.setOnClickListener {
            val textView = dialog.findViewById<TextView>(R.id.globeOfSPCcho)
            val phoneNum = textView.text.toString()
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNum")
            startActivity(callIntent)
        }


        dialog.show()
    }
    //create class for checkPermission
    private fun checkPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 101)//Check for permission
        }
    }

    // Handle the result of the permission request
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 101) {
            if (grantResults.isNotEmpty() && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                // Permission denied, force close the app
                finish()
            }
        }
    }
}