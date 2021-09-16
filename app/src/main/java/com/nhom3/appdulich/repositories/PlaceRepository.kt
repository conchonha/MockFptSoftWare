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

    suspend fun getDataBannerRandom() = callData {
        _api.getDataBannerRandom()
    }

    suspend fun getDataPlaceHomeRandom(idMenu : Int, check : Int) = callData {
        _api.getDataPlaceHomeRandom(idMenu,check)
    }

    suspend fun getDataImageHomeRandom() = callData {
        _api.getDataImageHomeRandom()
    }

    //-------------------------MENU --------------------
    suspend fun getMenuTop() = callData {
        _api.getDataMenuTop()
    }

    suspend fun getDataMenuBottom() = callData {
        _api.getDataMenuBottom()
    }

    //-------------------------EVENT --------------------

    suspend fun getDataEventRanDom() = callData {
        _api.getDataEventRanDom()
    }
}