package com.example.batikkita.ui.scan

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.batikkita.databinding.ActivityScanBinding
import com.example.batikkita.interfaces.RecognitionOnClickInterface
import com.example.batikkita.ui.detail.DetailActivity
import com.example.batikkita.utils.BitmapHelper
import com.example.batikkita.utils.ScanHelper
import com.example.batikkita.utils.ViewModelFactory
import java.util.*

class ScanActivity : AppCompatActivity(), RecognitionOnClickInterface {

    private lateinit var binding: ActivityScanBinding
    private lateinit var adapter: RecognitionAdapter

    private lateinit var viewModel: ScanViewModel

    private lateinit var recognition: ArrayList<Recognition>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ScanHelper.dataIsReady = false

        ScanHelper.updateBoolean(false)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this@ScanActivity, factory)[ScanViewModel::class.java]

        recognition =
            intent.getParcelableArrayListExtra<Recognition>(RECOGNITION) as ArrayList<Recognition>

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
        adapter.dataInterface = this
        binding.rvScan.adapter = adapter
        adapter.submitList(recognition)
        adapter.notifyDataSetChanged()
        BitmapHelper.bitmap = null

    }

    companion object {
        const val RECOGNITION = "recognition"
    }

    override fun onClicked(view: View, data: Recognition) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_NAME, data.splitLabel)
        startActivity(intent)
    }
}