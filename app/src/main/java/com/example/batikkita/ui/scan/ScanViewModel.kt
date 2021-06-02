package com.example.batikkita.ui.scan

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.batikkita.data.source.BatikRepository
import com.example.batikkita.data.source.local.entity.BatikEntity
import com.example.vo.Resource

class ScanViewModel (private val batikRepository: BatikRepository) : ViewModel() {
    fun getDetailBatikByName(name: String): LiveData<BatikEntity> = batikRepository.getDetailBatikByName(name)
}