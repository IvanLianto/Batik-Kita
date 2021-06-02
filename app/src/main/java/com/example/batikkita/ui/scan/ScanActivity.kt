package com.example.batikkita.ui.scan

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.batikkita.data.source.local.entity.BatikEntity
import com.example.batikkita.databinding.ActivityScanBinding
import com.example.batikkita.interfaces.RecognitionOnClickInterface
import com.example.batikkita.ui.detail.DetailActivity
import com.example.batikkita.utils.BitmapHelper
import com.example.batikkita.utils.DummyObject
import com.example.batikkita.utils.ScanHelper
import com.example.batikkita.utils.ViewModelFactory
import java.util.*

class ScanActivity : AppCompatActivity(), RecognitionOnClickInterface {

    private lateinit var binding: ActivityScanBinding
    private lateinit var adapter: RecognitionAdapter
    private lateinit var bitmapBuffer: Bitmap

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

//        viewModel.getDetailBatikByName(recognition[0].splitLabel).observe(this, { list ->
//            Toast.makeText(this, list.image, Toast.LENGTH_SHORT).show()
//            image = list.image
//        })
//        Toast.makeText(this, image, Toast.LENGTH_SHORT).show()

//        for (i in recognition.indices) {
//            viewModel.getDetailBatikByName(recognition[1].splitLabel).observe(this, { list ->
//                Log.d("TAG", list.image)
//            })
//        }

        recognition[0].image = DummyObject.getByName(recognition[0].splitLabel)
        recognition[1].image = DummyObject.getByName(recognition[1].splitLabel)
        recognition[2].image = DummyObject.getByName(recognition[2].splitLabel)

//        recognition[0].image = observerImageBatik(recognition[0].label)
//        recognition[1].image = observerImageBatik(recognition[1].label)
//        recognition[2].image = observerImageBatik(recognition[2].label)

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
        intent.putExtra(DetailActivity.EXTRA_NAME, data.label)
        startActivity(intent)
    }
}