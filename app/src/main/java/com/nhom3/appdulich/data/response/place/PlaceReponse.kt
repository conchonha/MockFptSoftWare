package com.nhom3.appdulich.data.response.place

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.nhom3.appdulich.data.model.Menu
import com.nhom3.appdulich.data.model.Place

data class PlaceReponse(
    @SerializedName("message") @Expose
    var message: String? = null,

    @SerializedName("statuscode")
    @Expose
    val statuscode: String? = null,

    @SerializedName("total")
    @Expose
    val total: Int? = null,

    @SerializedName("data")
    @Expose
    var data: List<Place>? = null
)