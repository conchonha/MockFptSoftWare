package com.nhom3.appdulich.core.service

import com.nhom3.appdulich.data.body.LoginBody
import com.nhom3.appdulich.data.body.NewPasswordBody
import com.nhom3.appdulich.data.body.RegisterBody
import com.nhom3.appdulich.data.response.account.LoginResponse
import com.nhom3.appdulich.data.response.account.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiServices {

    @POST("rest-api/User/login")
    suspend fun postLogin(
        @Body loginBody: LoginBody
    ): LoginResponse

    @POST("rest-api/User/register")
    suspend fun registerAccount(
        @Body registerBody: RegisterBody
    ): RegisterResponse

    @FormUrlEncoded
    @POST("rest-api/User/checkEmail")
    suspend fun checkEmail(
        @Field("email") email: String
    ): LoginResponse

    @POST("rest-api/User/updatePass")
    suspend fun newPassword(
        @Body newPasswordBody: NewPasswordBody
    ) : LoginResponse
}