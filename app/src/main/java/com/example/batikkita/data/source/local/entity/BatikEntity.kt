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

    @ColumnInfo(name = "island")
    var island: String,

    @ColumnInfo(name = "desc")
    var desc: String,

    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false

) : Parcelable
