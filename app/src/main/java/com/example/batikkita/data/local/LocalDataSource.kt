package com.example.batikkita.data.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.example.batikkita.data.local.room.BatikDao
import com.example.batikkita.data.model.BatikModel

class LocalDataSource private constructor(private val batikDao: BatikDao){
    fun getListBatik(): DataSource.Factory<Int, BatikModel> = batikDao.getListBatik()

    fun getListFavoriteBatik(): DataSource.Factory<Int, BatikModel> = batikDao.getListFavoriteBatik()

    fun getBatikDetail(dataId: Int): LiveData<BatikModel> = batikDao.getBatikDetail(dataId)

    fun searchBatik(name: String): DataSource.Factory<Int, BatikModel> = batikDao.searchBatik(name)

    fun setFavorite(data: BatikModel) {
        data.favorite = !data.favorite
        batikDao.updateData(data)
    }

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(batikDao: BatikDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(batikDao)
    }

}