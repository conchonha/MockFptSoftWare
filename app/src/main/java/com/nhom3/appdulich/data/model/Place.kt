package com.nhom3.appdulich.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "tb_place")
data class Place(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "image")
    val image: String ?= null,

    @ColumnInfo(name = "introduce")
    val introduce: String?=null,

    @ColumnInfo(name = "overview")
    val overview : String,

    @ColumnInfo(name = "arrayImageView")
    val arrayImageView: String,

    @ColumnInfo(name = "idIngredient")
    val idIngredient: Int,

    @ColumnInfo(name = "lat")
    val lat : String,

    @ColumnInfo(name = "lng")
    val lng: String,

    @ColumnInfo(name = "idMenu")
    val idMenu: Int,

    @ColumnInfo(name = "createdAt")
    val createdAt: Objects,

    @ColumnInfo(name = "updateAt")
    val updateAt : Objects


)