package com.nhom3.appdulich.repositories

import com.nhom3.appdulich.base.BaseRepository
import com.nhom3.appdulich.core.service.ApiServices
import javax.inject.Inject

class MenuRepository @Inject constructor(private val _api : ApiServices) : BaseRepository(){
    suspend fun getAllMenu() = callData {
        _api.getDataMenuAll()
    }
}