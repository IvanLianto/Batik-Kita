package com.example.batikkita.ui.scan

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.util.Size
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.batikkita.R
import com.example.batikkita.databinding.FragmentScanBinding

class ScanFragment : Fragment() {

    private lateinit var binding: FragmentScanBinding

    private lateinit var imageAnalyzer: ImageAnalysis

    private lateinit var cameraProvider: ProcessCameraProvider

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScanBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.layoutForScan.layoutImageStartToCamera.setOnClickListener {
            binding.layoutForScan.layoutImageStartToCamera.visibility = View.GONE
            binding.layoutForScan.tvScanYourBatik.visibility = View.GONE
            binding.layoutForScan.pvCamera.visibility = View.VISIBLE
            binding.layoutForScan.btnTakePicture.visibility = View.VISIBLE
            startCamera()
        }

        if (!allPermissionGranted())
            ActivityCompat.requestPermissions(requireActivity(), REQUIRED_PERMISSIONS, REQUEST_CODE)
    }

    private fun closeCamera() {
        cameraProvider.unbindAll()
    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())

        cameraProviderFuture.addListener({

            cameraProvider = cameraProviderFuture.get()

            val preview = Preview.Builder()
                .build()
                .also { mPreview ->
                    mPreview.setSurfaceProvider(binding.layoutForScan.pvCamera.surfaceProvider)
                }

            imageAnalyzer = ImageAnalysis.Builder()
                .setTargetResolution(Size(224, 224))
                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                .build()

            val cameraSelector =
                if (cameraProvider.hasCamera(CameraSelector.DEFAULT_BACK_CAMERA))
                    CameraSelector.DEFAULT_BACK_CAMERA else CameraSelector.DEFAULT_FRONT_CAMERA

            try {
                cameraProvider.unbindAll()

                cameraProvider.bindToLifecycle(
                    viewLifecycleOwner, cameraSelector, preview, imageAnalyzer
                )
            } catch (e: Exception) {
                Log.d(TAG, e.message.toString())
            }
        }, ContextCompat.getMainExecutor(requireContext()))
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_CODE) {
            if (allPermissionGranted()) {
                startCamera()
            } else {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.permission_deny_text),
                    Toast.LENGTH_SHORT
                ).show()
                requireActivity().finish()
            }
        }
    }

    private fun allPermissionGranted() =
        REQUIRED_PERMISSIONS.all {
            ContextCompat.checkSelfPermission(
                requireContext().applicationContext, it
            ) == PackageManager.PERMISSION_GRANTED
        }

    companion object {
        const val TAG = "CameraX"
        const val REQUEST_CODE = 123
        val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
    }

}