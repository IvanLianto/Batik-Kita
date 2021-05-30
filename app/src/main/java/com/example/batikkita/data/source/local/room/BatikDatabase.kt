package com.example.batikkita.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.batikkita.data.source.local.entity.BatikEntity
import com.example.batikkita.data.source.local.entity.IslandEntity

@Database(entities = [BatikEntity::class, IslandEntity::class], version = 1, exportSchema = false)
abstract class BatikDatabase : RoomDatabase() {
    abstract fun getDao(): BatikDao

    companion object {
        @Volatile
        private var INSTANCE: BatikDatabase? = null

        fun getInstance(context: Context): BatikDatabase =
            INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                BatikDatabase::class.java,
                "batik.db"
            ).build().apply {
                INSTANCE = this
            }
    }

}