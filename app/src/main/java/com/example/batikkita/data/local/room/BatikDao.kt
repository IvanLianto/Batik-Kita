package com.example.batikkita.data.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.example.batikkita.data.model.BatikModel

@Dao
interface BatikDao {
    @Query("SELECT * FROM batikEntities")
    fun getListBatik(): DataSource.Factory<Int, BatikModel>

    @Query("SELECT * FROM batikEntities WHERE id = :dataId")
    fun getBatikDetail(dataId: Int): LiveData<BatikModel>

    @Query("SELECT * FROM batikEntities WHERE favorite = 1")
    fun getListFavoriteBatik(): DataSource.Factory<Int, BatikModel>

    @Update(entity = BatikModel::class)
    fun updateData(data: BatikModel)

    @Query("SELECT * FROM batikEntities WHERE name LIKE :name ")
    fun searchBatik(name: String): DataSource.Factory<Int, BatikModel>

}