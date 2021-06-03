package com.example.batikkita.interfaces

import android.view.View
import com.example.batikkita.data.source.local.entity.BatikEntity
import com.example.batikkita.ui.scan.Recognition

interface BatikOnClickInterface {
    fun onClicked(view: View, data: BatikEntity)
}

interface RecognitionOnClickInterface {
    fun onClicked(view: View, data: Recognition)
}