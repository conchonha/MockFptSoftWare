package com.nhom3.appdulich.core.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nhom3.appdulich.core.room.FavoritePlace
import com.nhom3.appdulich.core.room.dao.PlaceDao
import com.nhom3.appdulich.data.model.Place

@Database(entities = [FavoritePlace::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getFavoritePlaceDao(): PlaceDao
}