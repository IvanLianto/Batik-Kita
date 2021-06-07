package com.example.batikkita.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.batikkita.R
import com.example.batikkita.data.source.local.entity.BatikEntity
import com.example.batikkita.databinding.ItemListBinding
import com.example.batikkita.interfaces.BatikOnClickInterface

class SearchAdapter : ListAdapter<BatikEntity, SearchAdapter.SearchViewHolder>(DiffCallback()) {

    var dataInterface: BatikOnClickInterface? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class SearchViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: BatikEntity) {
            binding.apply {
                Glide.with(root)
                    .load(data.image)
                    .placeholder(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
                    .into(ivPoster)
                tvBatik.text = data.name
                tvLocation.text = data.origin
                layoutRoot.setOnClickListener {
                    dataInterface?.onClicked(root, data)
                }
            }
        }
    }

}

class DiffCallback : DiffUtil.ItemCallback<BatikEntity>() {
    override fun areItemsTheSame(oldItem: BatikEntity, newItem: BatikEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BatikEntity, newItem: BatikEntity): Boolean {
        return oldItem.id == newItem.id
    }

}