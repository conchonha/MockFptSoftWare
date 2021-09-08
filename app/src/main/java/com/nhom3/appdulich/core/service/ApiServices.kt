package com.nhom3.appdulich.core.service

import com.nhom3.appdulich.data.body.LoginBody
import com.nhom3.appdulich.data.response.account.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiServices {

    @POST("rest-api/User/login")
    suspend fun postLogin(
        @Body loginBody: LoginBody
    ): LoginResponse
}