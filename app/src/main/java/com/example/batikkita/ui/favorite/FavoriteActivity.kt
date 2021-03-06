package com.example.batikkita.ui.favorite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.batikkita.data.source.local.entity.BatikEntity
import com.example.batikkita.databinding.ActivityFavoriteBinding
import com.example.batikkita.interfaces.BatikOnClickInterface
import com.example.batikkita.ui.detail.DetailActivity
import com.example.batikkita.utils.ViewModelFactory
import com.example.batikkita.utils.show

class FavoriteActivity : AppCompatActivity(), BatikOnClickInterface {

    private lateinit var binding: ActivityFavoriteBinding
    private lateinit var viewModel: FavoriteViewModel
    private lateinit var adapter: FavoriteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(applicationContext)
        viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]
        adapter = FavoriteAdapter()
        adapter.dataInterface = this
        binding.rvFavorite.adapter = adapter
        observerRecyclerView()

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun observerRecyclerView() {
        viewModel.getFavoriteList().observe(this, { list ->
            if (list != null) {
                if (list.isNotEmpty()) {
                    isEmpty(false)
                    adapter.submitList(list)
                    adapter.notifyDataSetChanged()
                } else {
                    isEmpty(true)
                }
            }
        })
    }

    private fun isEmpty(flag: Boolean) {
        binding.apply {
            emptyLayout.show(flag)
            rvFavorite.show(!flag)
        }
    }

    override fun onClicked(view: View, data: BatikEntity) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_ID, data.id)
        startActivity(intent)
    }


}