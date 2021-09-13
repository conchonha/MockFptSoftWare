package com.nhom3.appdulich.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

@Entity(tableName = "tb_place")
data class Place(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "name")
    val name: String? = null,

    @ColumnInfo(name = "image")
    val image: String? = null,

    @ColumnInfo(name = "introduce")
    val introduce: String ? = null,

    @ColumnInfo(name = "overview")
    val overview : String ? = null,

    @ColumnInfo(name = "arrayImageView")
    val arrayImageView: String ? = null,

    @ColumnInfo(name = "idIngredient")
    val idIngredient: Int ? = null,

    @ColumnInfo(name = "lat")
    val lat : String ? = null,

    @ColumnInfo(name = "lng")
    val lng: String ? = null,

    @ColumnInfo(name = "idMenu")
    val idMenu: Int ? = null,

    @ColumnInfo(name = "createdAt")
    val createdAt: String ? = null,

    @ColumnInfo(name = "updateAt")
    val updateAt : String ? = null,

) : Serializable