package com.nhom3.appdulich.data.response.account

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.nhom3.appdulich.data.model.Account

class LoginResponse {
    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("data")
    @Expose
    var data: Account? = null
}