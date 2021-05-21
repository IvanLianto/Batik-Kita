package com.example.batikkita.ui.scan

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.batikkita.R
import com.example.batikkita.databinding.ActivityScanBinding

class ScanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScanBinding
    private lateinit var adapter: RecognitionAdapter
    private lateinit var bitmapBuffer: Bitmap

    private lateinit var recognition: ArrayList<Recognition>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bitmapBuffer = intent.getParcelableExtra(IMAGE_RECOGNITION)!!
        recognition = intent.getParcelableArrayListExtra<Recognition>(RECOGNITION) as ArrayList<Recognition>

        binding.ivResultPicture.setImageBitmap(bitmapBuffer)

        binding.btnScanAgain.setOnClickListener {
            onBackPressed()
        }

        adapter = RecognitionAdapter()
        binding.rvScan.adapter = adapter
        adapter.submitList(recognition)
        adapter.notifyDataSetChanged()

    }

    companion object {
        const val IMAGE_RECOGNITION = "image_recognition"
        const val RECOGNITION = "recognition"
    }
}