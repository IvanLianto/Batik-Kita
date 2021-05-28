package com.example.batikkita.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.paging.PagingData
import com.example.batikkita.data.source.local.LocalDataSource
import com.example.batikkita.data.source.local.entity.BatikEntity
import com.example.batikkita.utils.AppExecutors
import com.example.batikkita.utils.DummyObject
import kotlinx.coroutines.CoroutineScope

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
        TODO("Not yet implemented")
    }

    override fun getListFavoriteBatik(): LiveData<PagedList<BatikEntity>> {
        TODO("Not yet implemented")
    }

    override fun searchBatik(name: String): LiveData<PagedList<BatikEntity>> {
        TODO("Not yet implemented")
    }

    override fun setFavorite(data: BatikEntity) {
        TODO("Not yet implemented")
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