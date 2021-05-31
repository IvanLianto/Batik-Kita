package com.example.batikkita.utils

import android.graphics.Bitmap
import android.view.View

object BitmapHelper {
    var bitmap: Bitmap? = null
}

object ScanHelper {
    var pauseAnalyzer : Boolean = false
    var readyToTake : Boolean = false
    var dataIsReady : Boolean = false
}

fun View.show(flag: Boolean) {
    visibility = if (flag) View.VISIBLE else View.GONE
}