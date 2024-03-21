package com.app.isanpablo.ui.map

import android.app.Dialog
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.app.isanpablo.R
import com.app.isanpablo.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment(), OnMapReadyCallback {

    private var _binding: ActivityMapsBinding? = null
    private val binding get() = _binding!!

    private lateinit var mMap: GoogleMap
    private lateinit var imageButton: ImageButton

    private val oldCapitalBuilding = LatLng(14.0745546, 121.3248985)
    private val donaLeonita = LatLng(14.074578, 121.3244506)
    private val policeStation = LatLng(14.0742329, 121.3245585)
    private val pamanahall = LatLng(14.074815, 121.3246301)
    private val newCapitalBuilding = LatLng(14.0744621, 121.3245659)
    private val oneStop = LatLng(14.0748101, 121.3244474)
    private val abc = LatLng(14.074867, 121.3243361)
    private val hallOfJustice = LatLng(14.0749195, 121.3244799)
    private val girlScout = LatLng(14.0744268, 121.3256782)
    private val assessor = LatLng(14.0744017, 121.3253047)

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
            newCapitalBuilding, oneStop, abc, hallOfJustice, girlScout, assessor
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
            // Return true to consume the event
            true
        }
    }

    private fun showpicDialog() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.image_view_dialog)
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