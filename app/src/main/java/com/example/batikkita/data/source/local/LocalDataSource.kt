package com.example.batikkita.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.example.batikkita.data.source.local.entity.BatikEntity
import com.example.batikkita.data.source.local.entity.CartEntity
import com.example.batikkita.data.source.local.entity.IslandEntity
import com.example.batikkita.data.source.local.room.BatikDao

class LocalDataSource private constructor(private val batikDao: BatikDao) {
    fun getListBatik(): DataSource.Factory<Int, BatikEntity> = batikDao.getListBatik()

    fun getListFavoriteBatik(): DataSource.Factory<Int, BatikEntity> =
        batikDao.getListFavoriteBatik()

    fun getListIsland(): LiveData<List<IslandEntity>> =
        batikDao.getListIsland()

    fun getListCart(): LiveData<List<CartEntity>> =
        batikDao.getListCart()

    fun getBatikDetail(dataId: Int): LiveData<BatikEntity> = batikDao.getBatikDetail(dataId)

    fun getBatikDetailByName(name: String): LiveData<BatikEntity> = batikDao.getBatikDetaikByName(name)

    fun searchBatik(name: String): DataSource.Factory<Int, BatikEntity> = batikDao.searchBatik("%$name%")

    fun setFavorite(data: BatikEntity) {
        data.favorite = !data.favorite
        batikDao.updateData(data)
    }

    fun insertData(data: List<BatikEntity>) {
        batikDao.insertData(data)
    }

    fun insertDataCart(data: List<CartEntity>){
        batikDao.insertDataCart(data)
    }

    fun insertDataIsland(data: List<IslandEntity>) {
        batikDao.insertDataIsland(data)
    }

    fun getDetailIsland(origin: String): LiveData<IslandEntity> = batikDao.getDetailIsland(origin)

    fun getListIslandBatik(origin: String): LiveData<List<BatikEntity>> = batikDao.getListIslandBatik(origin)

    fun getListIslandExceptIslandBatik(origin: String): LiveData<List<BatikEntity>> = batikDao.getListExceptIslandBatik(origin)

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(batikDao: BatikDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(batikDao)
    }

}