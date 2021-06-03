package com.example.batikkita.ui.scan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.batikkita.R
import com.example.batikkita.databinding.ItemListResultScanBinding
import com.example.batikkita.interfaces.RecognitionOnClickInterface
import java.util.*

class RecognitionAdapter : ListAdapter<Recognition, RecognitionAdapter.RecognitionViewHolder>(DiffCallback()) {

    var dataInterface: RecognitionOnClickInterface? = null

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

            Glide.with(binding.root)
                .load(recognition.image)
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
                .into(binding.ivBatik)

            binding.tvLabelBatik.text = recognition.splitLabel
            binding.tvPredictBatik.text = recognition.probabilityString

            binding.layoutRoot.setOnClickListener {
                dataInterface?.onClicked(
                    binding.root, recognition
                )
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
