package com.example.batikkita.ui.scan

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.batikkita.databinding.ItemListResultScanBinding
import com.example.batikkita.databinding.LayoutResultScanBinding

class RecognitionAdapter : ListAdapter<Recognition, RecognitionAdapter.RecognitionViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecognitionViewHolder {
        return RecognitionViewHolder(
            ItemListResultScanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecognitionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class RecognitionViewHolder(private val binding: ItemListResultScanBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(recognition: Recognition) {
            binding.tvLabelBatik.text = recognition.label
            binding.tvPredictBatik.text = recognition.probabilityString
        }
    }

}

class DiffCallback : DiffUtil.ItemCallback<Recognition>() {
    override fun areItemsTheSame(oldItem: Recognition, newItem: Recognition): Boolean {
        return oldItem.label == newItem.label
    }

    override fun areContentsTheSame(oldItem: Recognition, newItem: Recognition): Boolean {
        return oldItem.confidence == newItem.confidence
    }

}
