package com.example.batikkita.data.source

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.batikkita.data.source.local.LocalDataSource
import com.example.batikkita.data.source.local.entity.BatikEntity
import com.example.batikkita.utils.AppExecutors
import com.example.batikkita.utils.DummyObject

class BatikRepository private constructor(
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : BatikDataSource {

    override fun getListBatik(): LiveData<PagedList<BatikEntity>> {
        val dummyObject = DummyObject.generateBatik()
        appExecutors.diskIO().execute{
            localDataSource.insertData(dummyObject)
        }
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getListBatik(), config).build()
    }

    override fun getDetailBatik(dataId: Int): LiveData<BatikEntity> {
        return localDataSource.getBatikDetail(dataId)
    }

    override fun getListFavoriteBatik(): LiveData<PagedList<BatikEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getListFavoriteBatik(), config).build()
    }

    override fun searchBatik(name: String): LiveData<PagedList<BatikEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.searchBatik(name), config).build()
    }

    override fun setFavorite(data: BatikEntity) {
        appExecutors.diskIO().execute{localDataSource.setFavorite(data)}
    }

    companion object {
        @Volatile
        private var instance: BatikRepository? = null

        fun getInstance(
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): BatikRepository =
            instance ?: synchronized(this) {
                instance ?: BatikRepository(
                    localData,
                    appExecutors
                ).apply { instance = this }
            }
    }
}