package com.nhom3.appdulich.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nhom3.appdulich.base.response.DataResponse

abstract class BaseViewModel : ViewModel() {
    val loadingDialog = MutableLiveData<Boolean>()
    val dataResponse = MutableLiveData<DataResponse<*>>()

    //getter
    val loading get() : LiveData<Boolean> = loadingDialog
    val data get() : LiveData<DataResponse<*>> = dataResponse
}