package com.example.batikkita.ui.cart

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.batikkita.R
import com.example.batikkita.data.source.local.entity.CartEntity
import com.example.batikkita.databinding.ActivityCartDetailBinding
import com.example.batikkita.utils.ViewModelFactory

class CartDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCartDetailBinding
    private lateinit var viewModel: CartViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[CartViewModel::class.java]

        val id = intent.getIntExtra(EXTRA_ID, 0)

        if (id != 0) {
            viewModel.getDetailCart(id).observe(this, { data ->
                setBinding(data)
            })
        }

        binding.ivActionBack.setOnClickListener { onBackPressed() }

    }

    private fun setBinding(data: CartEntity) {
        binding.apply {
            Glide.with(root)
                .load(data.image)
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .into(ivPoster)
            tvBatik.text = data.name
            tvPrice.text = data.price
            tvPackingLocation.text =
                String.format(getString(R.string.packing_from_location), data.location)
            tvDescription.text = data.desc
            ratingBar.rating = data.rating.toFloat()
            btnBuy.setOnClickListener {
                Toast.makeText(this@CartDetailActivity, "COMING SOON!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        const val EXTRA_ID = "extra_id"
    }
}