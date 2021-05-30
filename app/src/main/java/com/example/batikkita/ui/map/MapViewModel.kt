package com.example.batikkita.ui.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.batikkita.data.source.BatikRepository
import com.example.batikkita.data.source.local.entity.IslandEntity
import com.example.vo.Resource

class MapViewModel(private val mBatikRepository: BatikRepository) : ViewModel() {
    fun getListIsland(): LiveData<Resource<List<IslandEntity>>> = mBatikRepository.getListIsland()
}