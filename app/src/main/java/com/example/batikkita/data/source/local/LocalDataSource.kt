package com.example.batikkita.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.example.batikkita.data.source.local.room.BatikDao
import com.example.batikkita.data.source.local.entity.BatikEntity

class LocalDataSource private constructor(private val batikDao: BatikDao){
    fun getListBatik(): DataSource.Factory<Int, BatikEntity> = batikDao.getListBatik()

    fun getListFavoriteBatik(): DataSource.Factory<Int, BatikEntity> = batikDao.getListFavoriteBatik()

    fun getBatikDetail(dataId: Int): LiveData<BatikEntity> = batikDao.getBatikDetail(dataId)

    fun searchBatik(name: String): DataSource.Factory<Int, BatikEntity> = batikDao.searchBatik(name)

    fun setFavorite(data: BatikEntity) {
        data.favorite = !data.favorite
        batikDao.updateData(data)
    }

    fun insertData(data: List<BatikEntity>) {
        batikDao.insertData(data)
    }

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(batikDao: BatikDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(batikDao)
    }

}