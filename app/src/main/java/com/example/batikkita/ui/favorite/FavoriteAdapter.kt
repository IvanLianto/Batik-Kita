package com.example.batikkita.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.batikkita.R
import com.example.batikkita.data.source.local.entity.BatikEntity
import com.example.batikkita.databinding.ItemListBinding
import com.example.batikkita.interfaces.BatikOnClickInterface

class FavoriteAdapter : PagedListAdapter<BatikEntity, FavoriteAdapter.FavoriteViewHolder> (DIFF_CALLBACK) {

    var dataInterface : BatikOnClickInterface? = null

    inner class FavoriteViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: BatikEntity){
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

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteAdapter.FavoriteViewHolder {
        return FavoriteViewHolder(
            ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: FavoriteAdapter.FavoriteViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null) {
            holder.bind(data)
        }
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