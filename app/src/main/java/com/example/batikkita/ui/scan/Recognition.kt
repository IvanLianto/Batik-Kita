package com.example.batikkita.ui.scan

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class Recognition(
    var label: String,
    var confidence: Float,
) : Parcelable {
    val probabilityString = String.format("%.1f%%", confidence * 100.0f)
    val splitString = label.split("-")
    val splitLabel = splitString[0].capitalize(Locale.ROOT) + " " + splitString[1].capitalize(Locale.ROOT)
}
