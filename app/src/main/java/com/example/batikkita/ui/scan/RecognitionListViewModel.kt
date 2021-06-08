package com.example.batikkita.ui.scan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecognitionListViewModel : ViewModel() {
    private val _recognitionList = MutableLiveData<List<Recognition>>()

    val recognitionList: LiveData<List<Recognition>> = _recognitionList

    fun updateData(recognition: List<Recognition>) {
        _recognitionList.postValue(recognition)
    }
}