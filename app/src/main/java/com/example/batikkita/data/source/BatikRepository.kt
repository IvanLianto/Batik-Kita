package com.example.batikkita.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.sqlite.db.SupportSQLiteQuery
import com.example.batikkita.data.NetworkBoundResource
import com.example.batikkita.data.source.local.LocalDataSource
import com.example.batikkita.data.source.local.entity.BatikEntity
import com.example.batikkita.data.source.local.entity.CartEntity
import com.example.batikkita.data.source.local.entity.IslandEntity
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

    override fun getListIsland(): LiveData<Resource<List<IslandEntity>>> {
        return object : NetworkBoundResource<List<IslandEntity>, List<IslandEntity>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<IslandEntity>> {
                return localDataSource.getListIsland()
            }

            override fun shouldFetch(data: List<IslandEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<IslandEntity>>> =
                remoteDataSource.getListIsland()

            override fun saveCallResult(data: List<IslandEntity>) {
                localDataSource.insertDataIsland(data)
            }
        }.asLiveData()
    }

    override fun getDetailBatik(dataId: Int): LiveData<BatikEntity> {
        return localDataSource.getBatikDetail(dataId)
    }

    override fun getDetailBatikByName(name: String): LiveData<BatikEntity> {
        return localDataSource.getBatikDetailByName(name)
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

    override fun searchBatikByFilter(query: SupportSQLiteQuery): LiveData<List<BatikEntity>> {
        return localDataSource.searchBatikByFilter(query)
    }

    override fun setFavorite(data: BatikEntity) {
        appExecutors.diskIO().execute{localDataSource.setFavorite(data)}
    }

    override fun getDetailIsland(origin: String): LiveData<IslandEntity> {
        return localDataSource.getDetailIsland(origin)
    }

    override fun getListIslandBatik(origin: String): LiveData<List<BatikEntity>> {
        return localDataSource.getListIslandBatik(origin)
    }

    override fun getListCart(): LiveData<Resource<List<CartEntity>>> {
        return object : NetworkBoundResource<List<CartEntity>, List<CartEntity>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<CartEntity>> {
                return localDataSource.getListCart()
            }

            override fun shouldFetch(data: List<CartEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<CartEntity>>> =
                remoteDataSource.getListCart()

            override fun saveCallResult(data: List<CartEntity>) {
                localDataSource.insertDataCart(data)
            }
        }.asLiveData()
    }

    override fun getDetailCartById(dataId: Int): LiveData<CartEntity> {
        return localDataSource.getDetailCart(dataId)
    }

    override fun getListIslandExceptIslandBatik(origin: String): LiveData<List<BatikEntity>> {
        return localDataSource.getListIslandExceptIslandBatik(origin)
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