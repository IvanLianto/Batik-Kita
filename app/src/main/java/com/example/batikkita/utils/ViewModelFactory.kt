package com.example.batikkita.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.batikkita.data.source.BatikRepository
import com.example.batikkita.di.Injection
import com.example.batikkita.ui.cart.CartViewModel
import com.example.batikkita.ui.detail.DetailViewModel
import com.example.batikkita.ui.favorite.FavoriteViewModel
import com.example.batikkita.ui.home.HomeViewModel
import com.example.batikkita.ui.map.MapViewModel
import com.example.batikkita.ui.mapDetail.MapDetailViewModel
import com.example.batikkita.ui.scan.ScanViewModel
import com.example.batikkita.ui.search.SearchViewModel

class ViewModelFactory private constructor(private val mBatikRepository: BatikRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(mBatikRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(mBatikRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(mBatikRepository) as T
            }
            modelClass.isAssignableFrom(MapViewModel::class.java) -> {
                MapViewModel(mBatikRepository) as T
            }
            modelClass.isAssignableFrom(MapDetailViewModel::class.java) -> {
                MapDetailViewModel(mBatikRepository) as T
            }
            modelClass.isAssignableFrom(ScanViewModel::class.java) -> {
                ScanViewModel(mBatikRepository) as T
            }
            modelClass.isAssignableFrom(CartViewModel::class.java) -> {
                CartViewModel(mBatikRepository) as T
            }
            modelClass.isAssignableFrom(SearchViewModel::class.java) -> {
                SearchViewModel(mBatikRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }
    }
}