package com.example.batikkita.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.batikkita.data.source.local.entity.BatikEntity
import com.example.vo.Resource

interface BatikDataSource {
    fun getListBatik(): LiveData<Resource<PagedList<BatikEntity>>>

    fun getDetailBatik(dataId: Int): LiveData<BatikEntity>

    fun getListFavoriteBatik(): LiveData<PagedList<BatikEntity>>

    fun searchBatik(name: String): LiveData<PagedList<BatikEntity>>

    fun setFavorite(data: BatikEntity)
}