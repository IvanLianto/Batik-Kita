package com.example.batikkita.utils

import android.app.AlertDialog
import android.content.Context
import android.graphics.Bitmap
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.batikkita.R
import kotlin.system.exitProcess

object BitmapHelper {
    var bitmap: Bitmap? = null
}

object ScanHelper {
    var pauseAnalyzer: Boolean = false

    private val readyToTake = MutableLiveData<Boolean>()

    val getReadyToTake: LiveData<Boolean> = readyToTake

    fun updateBoolean(flag: Boolean) {
        readyToTake.postValue(flag)
    }

    var dataIsReady: Boolean = false
}

object SearchHelper {
    var TYPE = "type"
}

fun View.show(flag: Boolean) {
    visibility = if (flag) View.VISIBLE else View.GONE
}

fun alertDialog(context: Context, title: String, message: String) {
    val builder = AlertDialog.Builder(context)
    with(builder)
    {
        setTitle(title)
        setMessage(message)
        setPositiveButton(
            context.getString(R.string.ok)
        ) { dialog, _ ->
            dialog.dismiss()
            exitProcess(0)
        }
        setCancelable(false)
        show()
    }
}