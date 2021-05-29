package com.example.batikkita.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.batikkita.data.source.local.entity.BatikEntity
import com.example.batikkita.utils.DummyObject

class RemoteDataSource {

    fun getListBatik(): LiveData<ApiResponse<List<BatikEntity>>> {
        val result = MutableLiveData<ApiResponse<List<BatikEntity>>>()
        result.postValue(ApiResponse.success(DummyObject.generateBatik()))
        return result
    }

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource().apply { instance = this }
            }
    }

}