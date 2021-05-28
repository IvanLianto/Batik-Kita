package com.example.batikkita.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.batikkita.data.source.BatikRepository
import com.example.batikkita.data.source.local.entity.BatikEntity

class HomeViewModel(private val batikRepository: BatikRepository) : ViewModel() {
    fun getListBatik(): LiveData<PagedList<BatikEntity>> = batikRepository.getListBatik()
}