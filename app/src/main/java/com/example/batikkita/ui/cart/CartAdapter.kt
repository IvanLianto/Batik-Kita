package com.example.batikkita.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.batikkita.R
import com.example.batikkita.data.source.local.entity.CartEntity
import com.example.batikkita.databinding.ItemListCartBinding
import com.example.batikkita.interfaces.CartOnClickInterface

class CartAdapter : ListAdapter<CartEntity, CartAdapter.ViewHolder>(DIFF_CALLBACK) {

    var dataInterface: CartOnClickInterface? = null

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CartEntity>() {
            override fun areItemsTheSame(oldItem: CartEntity, newItem: CartEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CartEntity, newItem: CartEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class ViewHolder(private val binding: ItemListCartBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: CartEntity, dataInterface: CartOnClickInterface?) {
            binding.apply {
                tvBatik.text = data.name
                tvPrice.text = data.price

                Glide.with(root)
                    .load(data.image)
                    .placeholder(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
                    .into(ivPoster)

                layoutRoot.setOnClickListener {
                    dataInterface?.onClicked(
                        root, data
                    )
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartAdapter.ViewHolder {
        return ViewHolder(
            ItemListCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CartAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position), dataInterface)
    }
}