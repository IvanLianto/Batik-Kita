package com.example.batikkita.interfaces

import android.view.View
import com.example.batikkita.data.source.local.entity.BatikEntity

interface BatikOnClickInterface {
    fun onClicked(view: View, data: BatikEntity)
}