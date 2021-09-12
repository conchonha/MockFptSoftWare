package com.nhom3.appdulich.ui.fragment.map

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.BaseFragment
import com.nhom3.appdulich.databinding.FragmentMapBinding
import com.nhom3.appdulich.viewmodel.MapViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "MAP"

@AndroidEntryPoint
@SuppressLint("MissingPermission")
class FragmentMap : BaseFragment<FragmentMapBinding>(), OnMapReadyCallback {
    private val _viewModel by viewModels<MapViewModel>()
    private lateinit var _fusedLocationClient: FusedLocationProviderClient
    private val _permissions by lazy { arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION) }

    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            checkGps()
        }

    private val requestMultiplePermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            if (permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true) {
                checkGps()
            } else {
                helpers.showAlertDialog(
                    msg = getString(R.string.lbl_permission),
                    context = requireContext()
                )
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
    }

    override fun getViewBinding() = FragmentMapBinding.inflate(layoutInflater)

    override fun listenerViewModel() {

    }

    override fun onInit() {
        initMap()
        checkPermission()
    }

    // check permission find location
    private fun checkPermission() {
        Log.d(TAG, "checkPermission: ")
        if (_viewModel.isPermissionGrand(_permissions)) {
            checkGps()
            return
        }
        requestMultiplePermissions.launch(_permissions)
    }

    // check  gps
    private fun checkGps() {
        Log.d(TAG, "checkGps: ")
        if (_viewModel.isGpsStatus()) {
            findLocation()
            return
        }
        helpers.showAlertDialog(
            msg = getString(R.string.lbl_location_error),
            context = requireContext(),
            onClick = {
                Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS).apply {
                    resultLauncher.launch(this)
                }
            }
        )
    }

    private fun findLocation() {
        Log.d(TAG, "findLocation: ")
        _fusedLocationClient.lastLocation.addOnCompleteListener { task ->
            Log.d(TAG, "findLocation: ${task.result.latitude} - ${task.result.longitude}")
            if (task.isSuccessful) {

                return@addOnCompleteListener
            }
        }
    }

    private fun initMap() {
        Log.d(TAG, "initMap: ")
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap) {
        Log.d(TAG, "onMapReady: ")
    }
}