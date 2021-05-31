package com.example.batikkita.ui.mapDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.batikkita.data.source.BatikRepository
import com.example.batikkita.data.source.local.entity.BatikEntity
import com.example.batikkita.data.source.local.entity.IslandEntity

class MapDetailViewModel(private val mBatikRepository: BatikRepository): ViewModel() {
    fun getDetailIsland(origin: String): LiveData<IslandEntity> = mBatikRepository.getDetailIsland(origin)

    fun getListIslandBatik(origin: String): LiveData<List<BatikEntity>> = mBatikRepository.getListIslandBatik(origin)

    fun getListIslandExceptBatik(origin: String): LiveData<List<BatikEntity>> = mBatikRepository.getListIslandExceptIslandBatik(origin)

}