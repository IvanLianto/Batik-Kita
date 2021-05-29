package com.example.batikkita.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.batikkita.data.source.local.entity.BatikEntity

interface BatikDataSource {
    fun getListBatik(): LiveData<PagedList<BatikEntity>>

    fun getDetailBatik(dataId: Int): LiveData<BatikEntity>

    fun getListFavoriteBatik(): LiveData<PagedList<BatikEntity>>

    fun searchBatik(name: String): LiveData<PagedList<BatikEntity>>

    fun setFavorite(data: BatikEntity)
}