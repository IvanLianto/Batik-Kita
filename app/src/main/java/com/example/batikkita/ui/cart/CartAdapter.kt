package com.example.batikkita.ui.cart

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.batikkita.data.source.local.entity.BatikEntity
import com.example.batikkita.interfaces.CartOnClickInterface
import com.example.batikkita.ui.home.HomeAdapter

class CartAdapter: PagedListAdapter<BatikEntity, HomeAdapter.HomeViewHolder>(DIFF_CALLBACK) {

    var dataInterface: CartOnClickInterface? = null

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.HomeViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: HomeAdapter.HomeViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}