package com.example.batikkita.ui.scan

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.batikkita.R
import com.example.batikkita.databinding.ActivityScanBinding

class ScanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScanBinding
    private lateinit var bitmapBuffer: Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bitmapBuffer = intent.getParcelableExtra(IMAGE_RECOGNITION)!!

        binding.ivResultPicture.setImageBitmap(bitmapBuffer)

        binding.btnScanAgain.setOnClickListener {
            onBackPressed()
        }

    }

    companion object {
        const val IMAGE_RECOGNITION = "image_recognition"
    }
}