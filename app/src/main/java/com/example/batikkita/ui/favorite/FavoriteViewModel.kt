package com.example.batikkita.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.batikkita.data.source.BatikRepository
import com.example.batikkita.data.source.local.entity.BatikEntity

class FavoriteViewModel(private val batikRepository: BatikRepository) : ViewModel() {
    fun getFavoriteList(): LiveData<PagedList<BatikEntity>> = batikRepository.getListFavoriteBatik()
}