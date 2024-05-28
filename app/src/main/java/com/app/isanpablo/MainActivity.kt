package com.app.isanpablo

import android.Manifest
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.app.isanpablo.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class MainActivity : AppCompatActivity() {

    // Google sign-in variables
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private var isLoginPage = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // This code is for Google Sign-in
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail().build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener {
            showhotline()
        }
        checkPermission()

        // This code is for drawer layout
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,R.id.nav_thecity,R.id.nav_government,R.id.nav_economy,R.id.nav_arta,
                R.id.nav_foi,R.id.nav_tourism
            ), drawerLayout
        )

        // This code is for navigation
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        navController.addOnDestinationChangedListener { _, destination, _ ->
            isLoginPage =destination.id == R.id.nav_login || destination.id == R.id.nav_signin
            updateAppBarVisibility()
            updateHotlineVisibility()

        }

        //
        binding.appBarMain.fab.setOnClickListener {
            if (!isLoginPage) {
                showhotline()
            }
        }
    }

    private fun updateAppBarVisibility() {
        if (isLoginPage) {
            supportActionBar?.hide()
        } else {
            supportActionBar?.show()
        }
    }
    private fun updateHotlineVisibility() {
        if (isLoginPage) {
            binding.appBarMain.fab.hide()
        } else {
            binding.appBarMain.fab.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
    private fun checkPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 101)//Check for permission
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                showLogoutDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun showLogoutDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Logout")
        builder.setMessage("Are you sure you want to logout?")
        builder.setPositiveButton("Yes") { dialog, which ->
            // Use findNavController on the current fragment to navigate to the logout destination
            logout()
        }
        builder.setNegativeButton("No") { dialog, which ->
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }
    private fun logout() {
        // Firebase sign out
        FirebaseAuth.getInstance().signOut()

        // Google sign out
        mGoogleSignInClient.signOut().addOnCompleteListener {
            // Once sign-out is complete, navigate to the login screen
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main)?.findNavController()?.navigate(R.id.nav_login)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    private fun showhotline() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.city_hotline)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.setBackgroundDrawableResource(R.drawable.shape_rounded_dialog_border)

        val btnClose = dialog.findViewById<ImageView>(R.id.exitto) // assuming you have an ImageView with id "btnClose" in your layout
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
}