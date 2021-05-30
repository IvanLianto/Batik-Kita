package com.example.batikkita.ui.mapDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.batikkita.R
import com.example.batikkita.data.source.local.entity.IslandEntity
import com.example.batikkita.databinding.ActivityMapDetailBinding
import com.example.batikkita.utils.ViewModelFactory

class MapDetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMapDetailBinding
    private lateinit var adapter: MapDetailAdapter
    private lateinit var viewModel: MapDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[MapDetailViewModel::class.java]

        val origin = intent.getStringExtra(EXTRA_ORIGIN)

        if (origin != null) {
            observerDetailIsland(origin)
        }

        binding.ivActionBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun observerDetailIsland(origin: String) {
        viewModel.getDetailIsland(origin).observe(this, { list ->
            setBinding(list)
        })
    }

    private fun setBinding(data: IslandEntity) {
        binding.apply {
            Glide.with(root)
                .load(data.image)
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .into(ivIsland)
            tvTitle.text = data.origin
            tvDetailIsland.text = data.description
        }
    }

    companion object {
        const val EXTRA_ORIGIN = "extra_origin"
    }
}