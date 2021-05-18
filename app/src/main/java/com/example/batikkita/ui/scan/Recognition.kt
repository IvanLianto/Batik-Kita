package com.example.batikkita.ui.scan

data class Recognition(
    val label: String,
    val confidence: Float
) {
    val probabilityString = String.format("%.1f%%", confidence * 100.0f)
}
