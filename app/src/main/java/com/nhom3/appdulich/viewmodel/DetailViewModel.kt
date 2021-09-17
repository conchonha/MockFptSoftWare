package com.nhom3.appdulich.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nhom3.appdulich.base.response.DataResponse
import com.nhom3.appdulich.data.response.DetailResponse
import com.nhom3.appdulich.repositories.PlaceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val _placeRepository: PlaceRepository
) : ViewModel() {
    var showError: ((String) -> Unit)? = null
    var loadingDialog: (() -> Unit)? = null

    fun getDataPlaceIdPlace(id: Int, onSuccess: (DetailResponse) -> Unit) = viewModelScope.launch {
        loadingDialog?.invoke()

        when (val value = _placeRepository.getDataPlaceIdPlace(id)) {
            is DataResponse.Success -> onSuccess(value.data)
            is DataResponse.Fail -> showError?.invoke(value.exception.message.toString())
        }
    }
}