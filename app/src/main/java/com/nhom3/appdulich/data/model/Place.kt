package com.nhom3.appdulich.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_place")
data class Place(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)