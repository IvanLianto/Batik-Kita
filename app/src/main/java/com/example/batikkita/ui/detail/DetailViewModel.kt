package com.example.batikkita.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.batikkita.data.source.BatikRepository
import com.example.batikkita.data.source.local.entity.BatikEntity

class DetailViewModel(private val batikRepository: BatikRepository) : ViewModel() {
    fun getDetailBatik(id: Int): LiveData<BatikEntity> = batikRepository.getDetailBatik(id)

    fun setFavorite(data: BatikEntity) = batikRepository.setFavorite(data)
}