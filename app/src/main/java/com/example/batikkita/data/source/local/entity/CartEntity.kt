package com.example.batikkita.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "cartEntities")
data class CartEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "store")
    var store: String,

    @ColumnInfo(name = "price")
    var price: String,

    @ColumnInfo(name = "location")
    var location: String,

    @ColumnInfo(name = "description")
    var desc: String,

    @ColumnInfo(name = "image")
    var image: String,

    @ColumnInfo(name = "rating")
    var rating: Double
) : Parcelable{
    constructor() : this(0,"","","","","", "",0.0)
}