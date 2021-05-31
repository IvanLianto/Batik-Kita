package com.example.batikkita.ui.scan

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.batikkita.databinding.ActivityScanBinding
import com.example.batikkita.utils.BitmapHelper
import com.example.batikkita.utils.ScanHelper

class ScanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScanBinding
    private lateinit var adapter: RecognitionAdapter
    private lateinit var bitmapBuffer: Bitmap

    private lateinit var recognition: ArrayList<Recognition>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ScanHelper.dataIsReady = false

        recognition = intent.getParcelableArrayListExtra<Recognition>(RECOGNITION) as ArrayList<Recognition>

        binding.ivResultPicture.setImageBitmap(BitmapHelper.bitmap)

        binding.btnScanAgain.setOnClickListener {
            ScanHelper.pauseAnalyzer = false
            onBackPressed()
        }

        binding.ivActionBack.setOnClickListener {
            ScanHelper.pauseAnalyzer = false
            onBackPressed()
        }

        adapter = RecognitionAdapter()
        binding.rvScan.adapter = adapter
        adapter.submitList(recognition)
        adapter.notifyDataSetChanged()
        BitmapHelper.bitmap = null

    }

    companion object {
        const val RECOGNITION = "recognition"
    }
}