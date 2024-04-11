package com.app.isanpablo.ui.map

import android.app.Dialog
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.app.isanpablo.R
import com.app.isanpablo.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment(), OnMapReadyCallback {

    private var _binding: ActivityMapsBinding? = null
    private val binding get() = _binding!!

    private lateinit var mMap: GoogleMap
    private lateinit var imageButton: ImageButton

    private val oldCapitalBuilding = LatLng(14.0745546, 121.3248985)
    private val donaLeonita = LatLng(14.0745991, 121.325239)
    private val policeStation = LatLng(14.0742329, 121.3245585)
    private val pamanahall = LatLng(14.0749863,121.3244641)
    private val newCapitalBuilding = LatLng(14.0744621, 121.3245659)
    private val oneStop = LatLng(14.074886447352126, 121.32484036256916)
    private val abc = LatLng(14.074771322735794, 121.32449569871731)
    private val hallOfJustice = LatLng(14.0751244, 121.3248124)
    private val girlScout = LatLng(14.074498598969566, 121.32605782089661)
    private val assessor = LatLng(14.074343882878967, 121.32575433869948)

    private var locationArray: ArrayList<LatLng>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityMapsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageButton = binding.imageButton
        imageButton.setOnClickListener {
            showpicDialog()
        }

        val mapFragment =
            childFragmentManager.findFragmentById(R.id.myMap) as? SupportMapFragment
        mapFragment?.getMapAsync(this)

        locationArray = arrayListOf(
            oldCapitalBuilding, donaLeonita, policeStation, pamanahall,
            newCapitalBuilding, oneStop, abc, hallOfJustice, assessor, girlScout
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        for (i in locationArray!!.indices) {
            val markerOptions = MarkerOptions().position(locationArray!![i]).title("Marker $i")
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(getMarkerIcon(i)))
            val marker = mMap.addMarker(markerOptions)
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(locationArray!![i], DEFAULT_ZOOM))
            if (marker != null) {
                marker.tag = i
            }
        }

        // Set up marker click listener
        mMap.setOnMarkerClickListener { marker ->
            // Retrieve the position of the tapped marker
            val position = marker.position
            // Animate the camera to zoom in on the tapped marker's position
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(position, MARKER_ZOOM))
            // Show custom info window
            showCustomInfoWindow(marker)
            // Return true to consume the event
            true
        }
    }
    private fun showCustomInfoWindow(marker: Marker) {
        // Create a custom info window adapter
        mMap.setInfoWindowAdapter(object : GoogleMap.InfoWindowAdapter {
            override fun getInfoWindow(p0: Marker): View? {
                return null
            }

            override fun getInfoContents(marker: Marker): View {
                val view = layoutInflater.inflate(R.layout.marker_picture, null)
                // Load image into ImageView
                val imageView = view.findViewById<ImageView>(R.id.imageView)
                val textView = view.findViewById<TextView>(R.id.textView)
                // Depending on your implementation, load the appropriate image here
                imageView.setImageResource(getImageForMarker(marker))
                textView.setText(getTextForMarker(marker))

                return view
            }
        })
        // Show the info window for the marker
        marker.showInfoWindow()
    }

    private fun getImageForMarker(marker: Marker): Int {
        // Determine the image resource based on the marker's position
        return when (marker.position) {
            oldCapitalBuilding -> R.drawable.ic_government_mapl_oldcityhall
            donaLeonita-> R.drawable.ic_government_map_dona
            policeStation -> R.drawable.ic_government_map_police
            pamanahall -> R.drawable.ic_government_map_pamana
            newCapitalBuilding -> R.drawable.ic_government_map_newbuilding
            oneStop -> R.drawable.ic_government_map_onestop
            abc -> R.drawable.ic_government_map_church
            girlScout -> R.drawable.ic_government_map_girl
            assessor -> R.drawable.ic_government_mapl_abc
            hallOfJustice ->R.drawable.ic_government_map_hallof
            else -> R.drawable.ic_government_map_church // Default image if no match found
        }
    }
    private fun getTextForMarker(marker: Marker): Int {
        // Determine the text resource based on the marker's position
        return when (marker.position) {
            oldCapitalBuilding -> R.string.old_capital_building_text
            donaLeonita -> R.string.dona_leonita_text
            policeStation -> R.string.police_station_text
            pamanahall -> R.string.pamanahall_text
            newCapitalBuilding -> R.string.new_capital_building_text
            oneStop -> R.string.one_stop_text
            abc -> R.string.abc_text
            hallOfJustice -> R.string.hall_of_justice_text
            girlScout -> R.string.girl_scout_text
            assessor -> R.string.assessor_text
            else -> R.string.default_text // Default text if no match found
        }
    }
    private fun showpicDialog() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.image_view_dialog)
        dialog.window?.setBackgroundDrawableResource(R.drawable.rounded_dialog_bg)
        dialog.show()
    }

    private fun getMarkerIcon(index: Int): Bitmap {
        // Load the drawable resource
        val drawable = when (index) {
            0 -> R.drawable.marker_blue
            1 -> R.drawable.marker_darkviolet
            2 -> R.drawable.marker_green
            3 -> R.drawable.marker_medyomaroon
            4 -> R.drawable.marker_orange
            5 -> R.drawable.marker_pink
            6 -> R.drawable.marker_red
            7 -> R.drawable.marker_violet
            8 -> R.drawable.marker_yellow
            9 -> R.drawable.marker_yellowgreen// Marker 1 will have a red icon
            else -> R.drawable.marker_red // Default marker icon
        }

        // Decode the drawable resource into a Bitmap
        val bitmap = BitmapFactory.decodeResource(resources, drawable)

        // Define the desired width and height of the marker
        val width = resources.getDimensionPixelSize(R.dimen.marker_width)
        val height = resources.getDimensionPixelSize(R.dimen.marker_height)

        // Scale the bitmap to the desired size
        // Scale the bitmap to the desired size
        return Bitmap.createScaledBitmap(bitmap, width, height, false)
    }

    companion object {
        private const val DEFAULT_ZOOM = 18f
        private const val MARKER_ZOOM = 20f
    }
}