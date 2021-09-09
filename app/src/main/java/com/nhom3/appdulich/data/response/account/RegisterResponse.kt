package com.nhom3.appdulich.data.response.account

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.nhom3.appdulich.data.model.Account


data class RegisterResponse(
    @SerializedName("message")
    @Expose
    var message: Any? = null,

    @SerializedName("statuscode")
    @Expose
    var statuscode: Int? = null,

    @SerializedName("total")
    @Expose
    var total: Int? = null,

    @SerializedName("data")
    @Expose
    var data: Account? = null
)