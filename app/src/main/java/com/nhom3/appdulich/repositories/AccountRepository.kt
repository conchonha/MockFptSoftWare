package com.nhom3.appdulich.repositories

import com.nhom3.appdulich.base.BaseRepository
import com.nhom3.appdulich.core.service.ApiServices
import com.nhom3.appdulich.data.body.LoginBody
import com.nhom3.appdulich.data.model.Account
import com.nhom3.appdulich.utils.SharePrefs
import javax.inject.Inject

class AccountRepository @Inject constructor(
    private val api: ApiServices,
    private val sharePrefs: SharePrefs
) :
    BaseRepository() {
    suspend fun login(loginBody: LoginBody) = callData { api.postLogin(loginBody) }

    fun checkAccount() : Boolean = sharePrefs.checkAccount()

    fun getAccount() : Account = sharePrefs.getAccount()

    fun saveAccount(account: Account) = sharePrefs.saveAccount(account)
}