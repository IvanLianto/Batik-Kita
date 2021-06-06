package com.example.batikkita.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.batikkita.data.source.local.entity.BatikEntity
import com.example.batikkita.data.source.local.entity.CartEntity
import com.example.batikkita.data.source.local.entity.IslandEntity

@Dao
interface BatikDao {
    @Query("SELECT * FROM batikEntities")
    fun getListBatik(): DataSource.Factory<Int, BatikEntity>

    @Query("SELECT * FROM batikEntities WHERE id = :dataId")
    fun getBatikDetail(dataId: Int): LiveData<BatikEntity>

    @Query("SELECT * FROM batikEntities WHERE name = :name")
    fun getBatikDetaikByName(name: String): LiveData<BatikEntity>

    @Query("SELECT * FROM batikEntities WHERE favorite = 1")
    fun getListFavoriteBatik(): DataSource.Factory<Int, BatikEntity>

    @Update(entity = BatikEntity::class)
    fun updateData(data: BatikEntity)

    @Query("SELECT * FROM batikEntities WHERE name LIKE :name ")
    fun searchBatik(name: String): DataSource.Factory<Int, BatikEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = BatikEntity::class)
    fun insertData(data: List<BatikEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = CartEntity::class)
    fun insertDataCart(data: List<CartEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = IslandEntity::class)
    fun insertDataIsland(data: List<IslandEntity>)

    @Query("SELECT * FROM islandEntity")
    fun getListIsland(): LiveData<List<IslandEntity>>

    @Query("SELECT * FROM islandEntity WHERE name LIKE :origin")
    fun getDetailIsland(origin: String): LiveData<IslandEntity>

    @Query("SELECT * FROM batikEntities WHERE island LIKE :origin")
    fun getListIslandBatik(origin: String): LiveData<List<BatikEntity>>

    @Query("SELECT * FROM batikEntities WHERE island NOT LIKE :origin")
    fun getListExceptIslandBatik(origin: String) : LiveData<List<BatikEntity>>

    @Query("SELECT * FROM cartEntities")
    fun getListCart(): LiveData<List<CartEntity>>

}