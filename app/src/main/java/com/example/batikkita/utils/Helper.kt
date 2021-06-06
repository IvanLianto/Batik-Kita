package com.example.batikkita.utils

import android.graphics.Bitmap
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object BitmapHelper {
    var bitmap: Bitmap? = null
}

object ScanHelper {
    var pauseAnalyzer : Boolean = false

    private val readyToTake = MutableLiveData<Boolean>()

    val getReadyToTake: LiveData<Boolean> = readyToTake

    fun updateBoolean(flag: Boolean) {
        readyToTake.postValue(flag)
    }

    var dataIsReady : Boolean = false
}

fun View.show(flag: Boolean) {
    visibility = if (flag) View.VISIBLE else View.GONE
}