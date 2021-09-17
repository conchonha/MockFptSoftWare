package com.nhom3.appdulich.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nhom3.appdulich.core.room.FavoritePlace
import com.nhom3.appdulich.core.room.dao.PlaceDao
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoritePlaceViewModel @Inject constructor(private val favoritePlaceDao: PlaceDao) : ViewModel() {

    suspend fun insertPlace(place: FavoritePlace) {
        favoritePlaceDao.insert(place)
    }

    suspend fun deletePlace(place: FavoritePlace) {
        favoritePlaceDao.delete(place)
    }

    fun getAllPlace(): LiveData<List<FavoritePlace>> {
        return favoritePlaceDao.getAllPlace()
    }

    fun searchPlace(namePlace: String): LiveData<List<FavoritePlace>> {
        return favoritePlaceDao.searchPlaceByName(namePlace)
    }
}