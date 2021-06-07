package com.example.batikkita.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.sqlite.db.SupportSQLiteQuery
import com.example.batikkita.data.source.local.entity.BatikEntity
import com.example.batikkita.data.source.local.entity.CartEntity
import com.example.batikkita.data.source.local.entity.IslandEntity
import com.example.vo.Resource

interface BatikDataSource {
    fun getListBatik(): LiveData<Resource<PagedList<BatikEntity>>>

    fun getListIsland(): LiveData<Resource<List<IslandEntity>>>

    fun getDetailBatik(dataId: Int): LiveData<BatikEntity>

    fun getDetailBatikByName(name: String): LiveData<BatikEntity>

    fun getListCart(): LiveData<Resource<List<CartEntity>>>

    fun getDetailCartById(dataId: Int): LiveData<CartEntity>

    fun getListFavoriteBatik(): LiveData<PagedList<BatikEntity>>

    fun searchBatik(name: String): LiveData<PagedList<BatikEntity>>

    fun searchBatikByFilter(query: SupportSQLiteQuery): LiveData<List<BatikEntity>>

    fun setFavorite(data: BatikEntity)

    fun getDetailIsland(origin: String): LiveData<IslandEntity>

    fun getListIslandBatik(origin: String): LiveData<List<BatikEntity>>

    fun getListIslandExceptIslandBatik(origin: String): LiveData<List<BatikEntity>>
}