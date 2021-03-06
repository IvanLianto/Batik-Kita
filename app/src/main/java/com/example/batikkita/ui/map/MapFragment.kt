package com.example.batikkita.ui.map

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.batikkita.BuildConfig.API_KEY_MAPBOX
import com.example.batikkita.R
import com.example.batikkita.data.source.local.entity.IslandEntity
import com.example.batikkita.databinding.FragmentMapBinding
import com.example.batikkita.ui.mapDetail.MapDetailActivity
import com.example.batikkita.utils.ViewModelFactory
import com.example.batikkita.utils.alertDialog
import com.example.batikkita.utils.show
import com.example.vo.Status
import com.google.gson.Gson
import com.mapbox.android.core.permissions.PermissionsManager
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.geometry.LatLngBounds
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.plugins.annotation.SymbolManager
import com.mapbox.mapboxsdk.plugins.annotation.SymbolOptions

class MapFragment : Fragment() {

    companion object {
        private const val ICON_ID = "ICON_ID"
    }

    private lateinit var symbolManager: SymbolManager

    private lateinit var binding: FragmentMapBinding
    private lateinit var viewModel: MapViewModel
    private lateinit var mapboxMap: MapboxMap

    private lateinit var permissionsManager: PermissionsManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Mapbox.getInstance(requireContext(), API_KEY_MAPBOX)
        binding = FragmentMapBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = ViewModelFactory.getInstance(requireContext())
        viewModel = ViewModelProvider(this, factory)[MapViewModel::class.java]
        binding.mapView.getMapAsync { mapboxMap ->
            this.mapboxMap = mapboxMap
            getIslandData()
        }
    }

    private fun getIslandData() {
        viewModel.getListIsland().observe(viewLifecycleOwner, { island ->
            if (island != null) {
                when (island.status) {
                    Status.LOADING -> {
                        isLoading(true)
                    }
                    Status.SUCCESS -> {
                        isLoading(false)
                        showMarker(island.data)
                    }
                    Status.ERROR -> {
                        isLoading(false)
                        alertDialog(requireContext(), "ERROR", "Check your internet connection!")
                    }
                }
            }
        })
    }

    private fun isLoading(flag: Boolean) {
        binding.apply {
            progressBar.show(flag)
            mapView.show(!flag)
        }
    }

    private fun showMarker(data: List<IslandEntity>?) {
        mapboxMap.setStyle(Style.MAPBOX_STREETS) { style ->
            style.addImage(
                ICON_ID,
                BitmapFactory.decodeResource(resources, R.drawable.mapbox_marker_icon_default)
            )
            val latLngBoundsBuilder = LatLngBounds.Builder()

            symbolManager = SymbolManager(binding.mapView, mapboxMap, style)
            symbolManager.iconAllowOverlap = true

            val options = ArrayList<SymbolOptions>()
            data?.forEach { list ->
                latLngBoundsBuilder.include(LatLng(list.latitude, list.longitude))
                options.add(
                    SymbolOptions()
                        .withLatLng(LatLng(list.latitude, list.longitude))
                        .withIconImage(ICON_ID)
                        .withIconSize(1.5f)
                        .withIconOffset(arrayOf(0f, -1.5f))
                        .withData(Gson().toJsonTree(list))
                )
            }
            symbolManager.create(options)
            symbolManager.addClickListener { symbol ->
                val data = Gson().fromJson(symbol.data, IslandEntity::class.java)
                val intent = Intent(requireContext(), MapDetailActivity::class.java)
                intent.putExtra(MapDetailActivity.EXTRA_ORIGIN, data.origin)
                startActivity(intent)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        binding.mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        binding.mapView.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.mapView.onSaveInstanceState(outState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()
    }
}