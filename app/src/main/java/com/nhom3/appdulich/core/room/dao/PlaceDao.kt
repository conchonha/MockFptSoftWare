package com.nhom3.appdulich.core.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.nhom3.appdulich.core.room.BaseDao
import com.nhom3.appdulich.data.model.Place

@Dao
interface PlaceDao : BaseDao<Place> {
    @Query("select * from tb_place")
    fun getAllPlace(): LiveData<List<Place>>
}