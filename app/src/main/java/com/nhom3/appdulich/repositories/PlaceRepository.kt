package com.nhom3.appdulich.repositories

import com.nhom3.appdulich.base.BaseRepository
import com.nhom3.appdulich.core.service.ApiServices
import javax.inject.Inject

class PlaceRepository @Inject constructor(private val _api : ApiServices) : BaseRepository(){
    suspend fun getDataPlaceFromIdMenu(idMenu : Int) = callData {
        _api.getDataPlaceFromIdMenu(idMenu)
    }

    suspend fun searchPlace(str : String) = callData {
        _api.searchPlace(str)
    }

    suspend fun getPlaceFromLng(name : String) = callData {
        _api.getPlaceFromName(name)
    }
}