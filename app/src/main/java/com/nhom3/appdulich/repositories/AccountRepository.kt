package com.nhom3.appdulich.repositories

import com.nhom3.appdulich.base.BaseRepository
import com.nhom3.appdulich.core.service.ApiServices
import com.nhom3.appdulich.core.service.JavaMailAPI
import com.nhom3.appdulich.data.body.*
import com.nhom3.appdulich.data.model.Account
import com.nhom3.appdulich.utils.SharePrefs
import javax.inject.Inject

class AccountRepository @Inject constructor(
    private val _api: ApiServices,
    private val _sharePrefs: SharePrefs
) :
    BaseRepository() {
    suspend fun login(loginBody: LoginBody) = callData { _api.postLogin(loginBody) }

    suspend fun register(registerBody: RegisterBody) =
        callData { _api.registerAccount(registerBody) }

    suspend fun sendVerifyMail(email: String, subject: String, message: String) = callData {
        JavaMailAPI.sendMail(
            email,
            subject,
            message
        )
    }

    suspend fun newPassword(newPasswordBody: NewPasswordBody) = callData {
        _api.newPassword(newPasswordBody)
    }

    suspend fun checkMailAccount(email: String) = callData {
        _api.checkEmail(email)
    }

    suspend fun updateProfile(updateProfileBody: UpdateProfileBody) = callData {
        _api.updateProfile(updateProfileBody)
    }

    suspend fun changePassword(body: ChangePasswordBody) = callData {
        _api.changePassword(body)
    }

    fun checkAccount(): Boolean = _sharePrefs.checkAccount()

    suspend fun getAccount() = callData { _sharePrefs.getAccount() }

    fun saveAccount(account: Account) = _sharePrefs.saveAccount(account)

    fun removeAccountLocal() = _sharePrefs.removeAccount()
}