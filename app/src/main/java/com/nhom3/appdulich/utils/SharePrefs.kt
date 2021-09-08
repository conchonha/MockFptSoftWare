package com.nhom3.appdulich.utils

import android.content.SharedPreferences
import com.google.gson.Gson
import com.nhom3.appdulich.data.model.Account
import javax.inject.Inject

class SharePrefs @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val editor: SharedPreferences.Editor
) {
    fun saveAccount(account: Account) {
        editor.putString(Const.KEY_ACCOUNT, Gson().toJson(account)).commit()
    }

    fun checkAccount(): Boolean {
        val data = sharedPreferences.getString(Const.KEY_ACCOUNT, "")
        if (data == "") {
            return false
        }
        return true
    }

    fun getAccount(): Account =
        Gson().fromJson(sharedPreferences.getString(Const.KEY_ACCOUNT, ""), Account::class.java)
}