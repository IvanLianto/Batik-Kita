package com.example.batikkita.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "batikEntities")
data class BatikEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "image")
    var image: String,

    @ColumnInfo(name = "origin")
    var origin: String,

    @ColumnInfo(name = "province")
    var province: String,

    @ColumnInfo(name = "island")
    var island: String,

    @ColumnInfo(name = "desc")
    var desc: String,

    @ColumnInfo(name = "theme")
    var theme: String,

    @ColumnInfo(name = "color")
    var color: String,

    @ColumnInfo(name = "complexity")
    var complexity: String,

    @ColumnInfo(name = "pattern")
    var pattern : String,

    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false

) : Parcelable{
    constructor() : this(0, "","","","","","","","","","",false)
}
