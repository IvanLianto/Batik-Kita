package com.example.batikkita.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.batikkita.data.NetworkBoundResource
import com.example.batikkita.data.source.local.LocalDataSource
import com.example.batikkita.data.source.local.entity.BatikEntity
import com.example.batikkita.data.source.remote.ApiResponse
import com.example.batikkita.data.source.remote.RemoteDataSource
import com.example.batikkita.utils.AppExecutors
import com.example.vo.Resource

class BatikRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : BatikDataSource {

    override fun getListBatik(): LiveData<Resource<PagedList<BatikEntity>>> {
        return object : NetworkBoundResource<PagedList<BatikEntity>, List<BatikEntity>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<BatikEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getListBatik(), config).build()
            }

            override fun shouldFetch(data: PagedList<BatikEntity>?) : Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<BatikEntity>>> =
                remoteDataSource.getListBatik()

            override fun saveCallResult(data: List<BatikEntity>) {
                localDataSource.insertData(data)
            }
        }.asLiveData()
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
            remoteDataSource: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): BatikRepository =
            instance ?: synchronized(this) {
                instance ?: BatikRepository(
                    remoteDataSource,
                    localData,
                    appExecutors
                ).apply { instance = this }
            }
    }
}