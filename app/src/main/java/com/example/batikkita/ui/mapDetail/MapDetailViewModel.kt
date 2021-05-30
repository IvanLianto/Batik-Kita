package com.example.batikkita.ui.mapDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.batikkita.data.source.BatikRepository
import com.example.batikkita.data.source.local.entity.IslandEntity

class MapDetailViewModel(private val mBatikRepository: BatikRepository): ViewModel() {
    fun getDetailIsland(origin: String): LiveData<IslandEntity> = mBatikRepository.getDetailIsland(origin)

}