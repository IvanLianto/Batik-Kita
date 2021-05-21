package com.example.batikkita.ui.scan

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recognition(
    val label: String,
    val confidence: Float
) : Parcelable {
    val probabilityString = String.format("%.1f%%", confidence * 100.0f)
}
