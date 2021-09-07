package com.nhom3.appdulich.base.response

sealed class DataResponse<T> {
    data class Success<T>(val data : T) : DataResponse<T>()
    data class Fail(val exception : Throwable) : DataResponse<Nothing>()
}