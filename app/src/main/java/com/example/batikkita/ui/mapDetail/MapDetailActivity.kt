package com.example.batikkita.ui.mapDetail

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.batikkita.R
import com.example.batikkita.data.source.local.entity.BatikEntity
import com.example.batikkita.data.source.local.entity.IslandEntity
import com.example.batikkita.databinding.ActivityMapDetailBinding
import com.example.batikkita.interfaces.BatikOnClickInterface
import com.example.batikkita.ui.detail.DetailActivity
import com.example.batikkita.utils.ViewModelFactory

class MapDetailActivity : AppCompatActivity(), BatikOnClickInterface {

    private lateinit var binding: ActivityMapDetailBinding
    private lateinit var listBatikIslandAdapter: MapDetailAdapter
    private lateinit var listBatikExceptIslandAdapter: MapDetailAdapter
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

        listBatikIslandAdapter = MapDetailAdapter()
        listBatikIslandAdapter.dataInterface = this
        binding.rvBatikIsland.adapter = listBatikIslandAdapter

        listBatikExceptIslandAdapter = MapDetailAdapter()
        listBatikExceptIslandAdapter.dataInterface = this
        binding.rvBatikNonIsland.adapter = listBatikExceptIslandAdapter

        if (origin != null) {
            observerListIslandBatik(origin)
        }

        if (origin != null) {
            observerListIslandExceptBatik(origin)
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

    private fun observerListIslandBatik(origin: String) {
        viewModel.getListIslandBatik(origin).observe(this, { list ->
            listBatikIslandAdapter.submitList(list)
            listBatikIslandAdapter.notifyDataSetChanged()
        })
    }

    private fun observerListIslandExceptBatik(origin: String) {
        viewModel.getListIslandExceptBatik(origin).observe(this, { list ->
            listBatikExceptIslandAdapter.submitList(list)
            listBatikExceptIslandAdapter.notifyDataSetChanged()
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

    override fun onClicked(view: View, data: BatikEntity) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_ID, data.id)
        startActivity(intent)
    }

    companion object {
        const val EXTRA_ORIGIN = "extra_origin"
    }

}