package com.rodionov.osport.presentation.map

import android.os.Bundle
import android.view.View
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.rodionov.osport.R
import com.rodionov.osport.app.platform.BaseFragment
import com.rodionov.osport.presentation.common.ScrollMapFragment

class MapFragment : BaseFragment(R.layout.fragment_map), OnMapReadyCallback {

    override val toolbarTitle = R.string.toolbar_title_map

    private var map: GoogleMap? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupMap(savedInstanceState)
    }

    override fun initViews() {

    }

    private fun setupMap (savedInstanceState: Bundle?) {
        val mapView = childFragmentManager.findFragmentById(R.id.mapView) as? ScrollMapFragment
        mapView?.onCreate(savedInstanceState)
        mapView?.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        map = googleMap
        map?.uiSettings?.isZoomControlsEnabled = false
        map?.uiSettings?.isScrollGesturesEnabledDuringRotateOrZoom = true
        map?.uiSettings?.setAllGesturesEnabled(true)
    }
}