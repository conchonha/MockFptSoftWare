package com.nhom3.appdulich.core.service

import com.nhom3.appdulich.data.body.*
import com.nhom3.appdulich.data.response.account.AccountResponse
import com.nhom3.appdulich.data.response.account.RegisterResponse
import retrofit2.http.*

interface ApiServices {

    @POST("rest-api/User/login")
    suspend fun postLogin(
        @Body loginBody: LoginBody
    ): AccountResponse

    @POST("rest-api/User/register")
    suspend fun registerAccount(
        @Body registerBody: RegisterBody
    ): RegisterResponse

    @FormUrlEncoded
    @POST("rest-api/User/checkEmail")
    suspend fun checkEmail(
        @Field("email") email: String
    ): AccountResponse

    @PUT("rest-api/User/newPassword")
    suspend fun newPassword(
        @Body newPasswordBody: NewPasswordBody
    ) : AccountResponse

    @POST("rest-api/User/updateUser")
    suspend fun updateProfile(
       @Body updateProfileBody: UpdateProfileBody
    ): AccountResponse

    @PUT("rest-api/User/updatePass")
    suspend fun changePassword(
        @Body changePasswordBody: ChangePasswordBody
    ) : AccountResponse
}