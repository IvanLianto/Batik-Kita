package com.example.batikkita.ui.scan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.batikkita.databinding.ItemListResultScanBinding
import com.example.batikkita.interfaces.RecognitionOnClickInterface

class RecognitionAdapter :
    ListAdapter<Recognition, RecognitionAdapter.RecognitionViewHolder>(DiffCallback()) {

    var dataInterface: RecognitionOnClickInterface? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecognitionViewHolder {
        return RecognitionViewHolder(
            ItemListResultScanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecognitionViewHolder, position: Int) {
        holder.bind(getItem(position), position + 1)
    }

    inner class RecognitionViewHolder(private val binding: ItemListResultScanBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(recognition: Recognition, position: Int) {

            with(binding) {
                tvLabelBatik.text = recognition.splitLabel
                tvPredictBatik.text = recognition.probabilityString
                tvPosition.text = position.toString()

                layoutRoot.setOnClickListener {
                    dataInterface?.onClicked(
                        binding.root, recognition
                    )
                }
            }
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
