package com.example.batikkita.ui.scan

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Matrix
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.util.Size
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.batikkita.R
import com.example.batikkita.databinding.FragmentScanBinding
import com.example.batikkita.ml.BatikKitaModel
import com.example.batikkita.utils.BitmapHelper
import com.example.batikkita.utils.ScanHelper
import com.example.batikkita.utils.YuvToRgbConverter
import org.tensorflow.lite.gpu.CompatibilityList
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.model.Model
import java.util.concurrent.Executors

class ScanFragment : Fragment() {

    private lateinit var binding: FragmentScanBinding
    private lateinit var imageAnalyzer: ImageAnalysis
    private lateinit var bitmapBuffer: Bitmap
    private lateinit var rotationMatrix: Matrix
    private lateinit var cameraProvider: ProcessCameraProvider
    private val cameraExecutor = Executors.newSingleThreadExecutor()

    private val viewModel: RecognitionListViewModel by viewModels()

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

        ScanHelper.updateBoolean(false)

        ScanHelper.getReadyToTake.observe(viewLifecycleOwner, {
            Log.d("TAG", it.toString())
            binding.layoutForScan.btnTakePicture.isEnabled = it
        })


        binding.layoutForScan.btnTakePicture.setOnClickListener {
            val matrix = Matrix().apply {
                postRotate(90.toFloat())
            }
            val uprightImage = Bitmap.createBitmap(
                bitmapBuffer, 0, 0, bitmapBuffer.width, bitmapBuffer.height, matrix, false
            )

            val intent = Intent(
                requireContext(), ScanActivity::class.java
            )

            sendData(intent)

            if (ScanHelper.dataIsReady) {
                BitmapHelper.bitmap = uprightImage
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }
        }

        if (!allPermissionGranted())
            ActivityCompat.requestPermissions(requireActivity(), REQUIRED_PERMISSIONS, REQUEST_CODE)

    }

    private fun sendData(intent: Intent) {
        viewModel.recognitionList.observe(viewLifecycleOwner, {
            if (it != null) {
                intent.putParcelableArrayListExtra(
                    ScanActivity.RECOGNITION,
                    it as java.util.ArrayList<out Parcelable>
                )
                ScanHelper.pauseAnalyzer = true
                ScanHelper.dataIsReady = true
            }
        })
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
                .setTargetResolution(Size(200, 200))
                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                .build()

            imageAnalyzer.setAnalyzer(cameraExecutor, ImageAnalysis.Analyzer { image ->

                if (ScanHelper.pauseAnalyzer) {
                    image.close()
                    return@Analyzer
                }

                val items = mutableListOf<Recognition>()

                val model: BatikKitaModel by lazy {
                    val compatList = CompatibilityList()

                    val options = if (compatList.isDelegateSupportedOnThisDevice) {
                        Log.d(TAG, "This device is GPU Compatible ")
                        Model.Options.Builder().setDevice(Model.Device.GPU).build()
                    } else {
                        Log.d(TAG, "This device is GPU Incompatible ")
                        Model.Options.Builder().setNumThreads(4).build()
                    }
                    BatikKitaModel.newInstance(requireContext(), options)
                }

                val tfImage = TensorImage.fromBitmap(toBitmap(image))

                val outputs = model.process(tfImage)
                    .probabilityAsCategoryList.apply {
                        sortByDescending { it.score }
                    }.take(3)

                for (output in outputs) {
                    items.add(
                        Recognition(
                            label = output.label,
                            confidence = output.score
                        )
                    )
                }

                viewModel.updateData(items)

                ScanHelper.updateBoolean(true)

                image.close()
            })

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

    @SuppressLint("UnsafeOptInUsageError")
    private fun toBitmap(image: ImageProxy): Bitmap? {
        if (!::bitmapBuffer.isInitialized) {
            rotationMatrix = Matrix()
            rotationMatrix.postRotate(image.imageInfo.rotationDegrees.toFloat())
            bitmapBuffer = Bitmap.createBitmap(
                image.width, image.height, Bitmap.Config.ARGB_8888
            )
        }
        val yuvToRgbConverter = YuvToRgbConverter(requireContext())
        yuvToRgbConverter.yuvToRgb(image.image!!, bitmapBuffer)
        return Bitmap.createBitmap(
            bitmapBuffer,
            0,
            0,
            bitmapBuffer.width,
            bitmapBuffer.height,
            rotationMatrix,
            false
        )
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