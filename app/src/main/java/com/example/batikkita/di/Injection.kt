package com.example.batikkita.di

import android.content.Context
import com.example.batikkita.data.source.BatikRepository
import com.example.batikkita.data.source.local.LocalDataSource
import com.example.batikkita.data.source.local.room.BatikDatabase
import com.example.batikkita.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): BatikRepository {
        val database = BatikDatabase.getInstance(context)
        val localDataSource = LocalDataSource.getInstance(database.getDao())
        val appExecutors = AppExecutors()
        return BatikRepository.getInstance(localDataSource, appExecutors)
    }
}