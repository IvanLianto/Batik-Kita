package com.example.batikkita.ui.mapDetail


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.batikkita.data.source.local.entity.BatikEntity
import com.example.batikkita.databinding.ItemListBinding
import com.example.batikkita.interfaces.BatikOnClickInterface

class MapDetailAdapter : ListAdapter<BatikEntity, MapDetailAdapter.ViewHolder>(DIFF_CALLBACK) {

    var dataInterface: BatikOnClickInterface?=null

    inner class ViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

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