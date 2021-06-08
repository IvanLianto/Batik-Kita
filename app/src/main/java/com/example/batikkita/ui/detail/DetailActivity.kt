package com.example.batikkita.ui.detail

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.batikkita.R
import com.example.batikkita.data.source.local.entity.BatikEntity
import com.example.batikkita.databinding.ActivityDetailBinding
import com.example.batikkita.utils.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this@DetailActivity, factory)[DetailViewModel::class.java]

        val id = intent.getIntExtra(EXTRA_ID, 0)
        val name = intent.getStringExtra(EXTRA_NAME)

        if (id != 0) {
            observerDetailBatik(id)
        }

        if (name != null) {
            observerDetailBatik(name)
        }

        binding.ivActionBack.setOnClickListener {
            onBackPressed()
        }

    }

    private fun observerDetailBatik(id: Int) {
        viewModel.getDetailBatik(id).observe(this, { list ->
            setBinding(list)
            setIconFavorite(list.favorite)
        })
    }

    private fun observerDetailBatik(name: String) {
        viewModel.getDetailBatik(name).observe(this, { list ->
            setBinding(list)
            setIconFavorite(list.favorite)
        })
    }

    private fun setBinding(data: BatikEntity) {
        binding.apply {
            Glide.with(root)
                .load(data.image)
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .into(ivPoster)
            tvTitle.text = data.name
            tvProvince.text = data.province
            tvTheme.text = data.theme
            tvColor.text = data.color
            tvComplexity.text = data.complexity
            tvDetailBatik.text = data.desc
            tvPattern.text = data.pattern
            binding.ivFavorite.setOnClickListener { setFavorite(data) }
        }
    }

    private fun setFavorite(data: BatikEntity) {
        if (!data.favorite) {
            Toast.makeText(
                this,
                String.format(getString(R.string.success_favorite), data.name),
                Toast.LENGTH_SHORT
            ).show()
            viewModel.setFavorite(data)
        } else {
            Toast.makeText(
                this,
                String.format(getString(R.string.success_unfavorite), data.name),
                Toast.LENGTH_SHORT
            ).show()
            viewModel.setFavorite(data)
        }
        setIconFavorite(data.favorite)
    }

    private fun setIconFavorite(flag: Boolean) {
        if (flag) {
            binding.ivFavorite.setImageResource(R.drawable.ic_favorite)
        } else {
            binding.ivFavorite.setImageResource(R.drawable.ic_favorite_border_24)
        }
    }

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_NAME = "extra_name"
    }
}