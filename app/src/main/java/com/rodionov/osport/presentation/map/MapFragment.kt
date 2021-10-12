package com.rodionov.osport.presentation.map

import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.toBitmap
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.rodionov.osport.R
import com.rodionov.base.ui.BaseFragment
import com.rodionov.osport.databinding.FragmentMapBinding
import com.rodionov.osport.presentation.common.ScrollMapFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MapFragment : BaseFragment(R.layout.fragment_map), OnMapReadyCallback {

    private val binding: FragmentMapBinding by viewBinding()

    override val toolbarTitle = R.string.toolbar_title_map

    override val toolbarDrawableClose = R.drawable.ic_toolbar_back

    private val viewModel : MapViewModel by viewModel()

    override val screenViewModel by lazy { viewModel }

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
        map?.mapType = GoogleMap.MAP_TYPE_NORMAL
        map?.uiSettings?.isZoomControlsEnabled = false
        map?.uiSettings?.isScrollGesturesEnabledDuringRotateOrZoom = true
        map?.uiSettings?.setAllGesturesEnabled(true)
        map?.setOnMapClickListener {

            setMarkerOnMap(LatLng(it.latitude, it.longitude))
        }
    }

    private fun setMarkerOnMap(latLng: LatLng, moveCamera: Boolean = true) {
        map?.clear()
        map?.addMarker(
            MarkerOptions().position(latLng).icon(
                BitmapDescriptorFactory.fromBitmap(
                    AppCompatResources.getDrawable(
                        requireContext(),
                        R.drawable.ic_event_location
                    )?.toBitmap()
                )
            )
        )
        if (moveCamera)
            map?.moveCamera(
                CameraUpdateFactory.newLatLngZoom(latLng, 6f)
            )
    }
}