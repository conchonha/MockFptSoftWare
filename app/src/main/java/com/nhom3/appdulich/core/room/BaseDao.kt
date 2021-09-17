package com.nhom3.appdulich.core.room

import androidx.room.*
import okhttp3.internal.concurrent.Task

@Dao
interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data : T)

    @Delete
    suspend fun delete(data : T)
}