package com.example.batikkita.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.batikkita.data.source.remote.ApiResponse
import com.example.batikkita.data.source.remote.StatusResponse
import com.example.batikkita.utils.AppExecutors
import com.example.vo.Resource

abstract class NetworkBoundResource <ResultType, RequestType> (private val mExecutors: AppExecutors){

    private val result = MediatorLiveData<Resource<ResultType>>()

    init {
        result.value = Resource.loading(null)

        @Suppress("LeakingThis")
        val dbSource = loadFromDB()

        result.addSource(dbSource) {data->
            result.removeSource(dbSource)
            if (shouldFetch(data)){
                fetchFromNetwork(dbSource)
            } else {
                result.addSource(dbSource) {
                    result.value = Resource.success(it)
                }
            }
        }
    }

    protected fun onFetchFailed(){}

    protected abstract fun loadFromDB(): LiveData<ResultType>
    protected abstract fun shouldFetch(data: ResultType?): Boolean
    protected abstract fun createCall(): LiveData<ApiResponse<RequestType>>
    protected abstract fun saveCallResult(data: RequestType)

    private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {

        val apiResponse = createCall()

        result.addSource(dbSource){
            result.value = Resource.loading(it)
        }

        result.addSource(apiResponse){ response ->
            result.removeSource(apiResponse)
            result.removeSource(dbSource)
            when(response.status){

                StatusResponse.SUCCESS ->{
                    mExecutors.diskIO().execute {
                        saveCallResult(response.body)
                        mExecutors.mainThread().execute {
                            result.addSource(loadFromDB()) {
                                result.value = Resource.success(it)
                            }
                        }
                    }
                }

                StatusResponse.EMPTY ->{
                    mExecutors.mainThread().execute {
                        result.addSource(loadFromDB()) {
                            result.value = Resource.success(it)
                        }
                    }
                }

                StatusResponse.ERROR ->{
                    onFetchFailed()
                    result.addSource(dbSource){
                        result.value = Resource.error(response.message, it)
                    }

                }
            }
        }
    }

    fun asLiveData(): LiveData<Resource<ResultType>> = result

}