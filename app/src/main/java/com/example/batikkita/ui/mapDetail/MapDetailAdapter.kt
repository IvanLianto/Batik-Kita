package com.example.batikkita.ui.mapDetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.batikkita.R
import com.example.batikkita.data.source.local.entity.BatikEntity
import com.example.batikkita.databinding.ItemListMapBinding
import com.example.batikkita.interfaces.BatikOnClickInterface

class MapDetailAdapter : ListAdapter<BatikEntity, MapDetailAdapter.ViewHolder>(DIFF_CALLBACK) {

    var dataInterface: BatikOnClickInterface? = null

    inner class ViewHolder(private val binding: ItemListMapBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: BatikEntity, dataInterface: BatikOnClickInterface?) {
            binding.apply {
                Glide.with(root)
                    .load(data.image)
                    .placeholder(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
                    .into(ivPoster)
                tvBatik.text = data.name
                tvLocation.text = data.origin
                layoutRoot.setOnClickListener {
                    dataInterface?.onClicked(
                        root, data
                    )
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemListMapBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), dataInterface)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<BatikEntity>() {
            override fun areItemsTheSame(oldItem: BatikEntity, newItem: BatikEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: BatikEntity, newItem: BatikEntity): Boolean {
                return oldItem == newItem
            }
        }
    }
}