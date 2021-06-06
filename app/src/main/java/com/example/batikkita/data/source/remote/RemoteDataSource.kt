package com.example.batikkita.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.batikkita.data.source.local.entity.BatikEntity
import com.example.batikkita.data.source.local.entity.CartEntity
import com.example.batikkita.data.source.local.entity.IslandEntity
import com.example.batikkita.utils.DummyObject
import com.google.firebase.firestore.FirebaseFirestore

class RemoteDataSource {

    private val db = FirebaseFirestore.getInstance()

    fun getListBatik(): LiveData<ApiResponse<List<BatikEntity>>> {
        val result = MutableLiveData<ApiResponse<List<BatikEntity>>>()
        db.collection("Batik")
            .get()
            .addOnCompleteListener{
                if (it.result != null){
                    val batikListEntity = ArrayList<BatikEntity>()
                    for(document in it.result!!){
                        val batik = document.toObject(BatikEntity::class.java)
                        batikListEntity.add(batik)
                    }
                    result.postValue(ApiResponse.success(batikListEntity))
                }
            }
        return result
    }

    fun getListIsland(): LiveData<ApiResponse<List<IslandEntity>>> {
        val result = MutableLiveData<ApiResponse<List<IslandEntity>>>()
        db.collection("Island")
            .get()
            .addOnCompleteListener { task ->
                if (task.result != null) {
                    val listIslandEntity = ArrayList<IslandEntity>()
                    for (document in task.result!!) {
                        val island = document.toObject(IslandEntity::class.java)
                        listIslandEntity.add(island)
                    }
                    result.postValue(ApiResponse.success(listIslandEntity))
                }
            }
        return result
    }

    fun getListCart(): LiveData<ApiResponse<List<CartEntity>>>{
        val result = MutableLiveData<ApiResponse<List<CartEntity>>>()
        db.collection("Cart")
            .get()
            .addOnCompleteListener{
                if (it.result != null){
                    val listCartEntity = ArrayList<CartEntity>()
                    for (document in it.result!!){
                        val cart = document.toObject(CartEntity::class.java)
                        listCartEntity.add(cart)
                    }
                    result.postValue(ApiResponse.success(listCartEntity))
                }
            }
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