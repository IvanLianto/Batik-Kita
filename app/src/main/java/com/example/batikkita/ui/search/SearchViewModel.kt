package com.example.batikkita.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.sqlite.db.SupportSQLiteQuery
import com.example.batikkita.data.source.BatikRepository
import com.example.batikkita.data.source.local.entity.BatikEntity

class SearchViewModel(private val batikRepository: BatikRepository) : ViewModel() {
    fun searchBatikByFilter(query: SupportSQLiteQuery): LiveData<List<BatikEntity>> =
        batikRepository.searchBatikByFilter(query)
}