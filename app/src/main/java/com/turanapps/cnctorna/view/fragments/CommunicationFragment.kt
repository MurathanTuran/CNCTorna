package com.turanapps.cnctorna.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.model.LatLng
import com.turanapps.cnctorna.databinding.FragmentCommunicationBinding

class CommunicationFragment : Fragment() {

    private lateinit var binding: FragmentCommunicationBinding

    private lateinit var mapView: MapView
    private lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunicationBinding.inflate(inflater)

        mapView = binding.mapView
        mapView.onCreate(savedInstanceState)

        mapView.getMapAsync { map ->
            googleMap = map
            MapsInitializer.initialize(requireActivity())
            val istanbul = LatLng(41.069716727588, 28.802674000000007)
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(istanbul, 15f))
            googleMap.uiSettings.isCompassEnabled = true
            googleMap.uiSettings.isZoomControlsEnabled = false
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

}