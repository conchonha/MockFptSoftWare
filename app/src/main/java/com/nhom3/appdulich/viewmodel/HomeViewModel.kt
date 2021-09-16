package com.nhom3.appdulich.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.response.DataResponse
import com.nhom3.appdulich.data.model.*
import com.nhom3.appdulich.repositories.AccountRepository
import com.nhom3.appdulich.repositories.PlaceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val _accountRepository: AccountRepository,
    private val _application: Application,
    private val _placeRepository: PlaceRepository
) : ViewModel() {
    var showError: ((String) -> Unit)? = null
    var loadingDialog: (() -> Unit)? = null

    fun getAccount(
        onSuccess: (Account) -> Unit,
        onFail: (String) -> Unit
    ) = viewModelScope.launch {
        when (val value = _accountRepository.getAccount()) {
            is DataResponse.Success -> onSuccess(value.data)
            is DataResponse.Fail -> onFail(_application.getString(R.string.lbl_account_error_local))
        }
    }

    fun getDataBannerRandom(onSuccess: (LiveData<List<Place>>) -> Unit) = viewModelScope.launch {
        loadingDialog?.invoke()

        when (val value = _placeRepository.getDataBannerRandom()) {
            is DataResponse.Success -> onSuccess(MutableLiveData(value.data.data!!))
            is DataResponse.Fail -> showError?.invoke(value.exception.message.toString())
        }
    }

    fun getMenuTop(onSuccess: (LiveData<List<Menu>>) -> Unit) = viewModelScope.launch {
        loadingDialog?.invoke()

        when (val value = _placeRepository.getMenuTop()) {
            is DataResponse.Success -> onSuccess(MutableLiveData(value.data.data!!))
            is DataResponse.Fail -> showError?.invoke(value.exception.message.toString())
        }
    }

    fun getDataMenuBottom(onSuccess: (LiveData<List<Menu>>) -> Unit) = viewModelScope.launch {
        loadingDialog?.invoke()

        when (val value = _placeRepository.getDataMenuBottom()) {
            is DataResponse.Success -> onSuccess(MutableLiveData(value.data.data!!))
            is DataResponse.Fail -> showError?.invoke(value.exception.message.toString())
        }
    }

    fun getDataEventRanDom(onSuccess: (LiveData<List<Event>>) -> Unit) = viewModelScope.launch {
        loadingDialog?.invoke()

        when (val value = _placeRepository.getDataEventRanDom()) {
            is DataResponse.Success -> onSuccess(MutableLiveData(value.data.data!!))
            is DataResponse.Fail -> showError?.invoke(value.exception.message.toString())
        }
    }

    fun getDataPlaceHomeRandom(
        idMenu: Int,
        check: Int,
        onSuccess: (LiveData<List<Place>>) -> Unit
    ) =
        viewModelScope.launch {

            when (val value = _placeRepository.getDataPlaceHomeRandom(idMenu, check)) {
                is DataResponse.Success -> onSuccess(MutableLiveData(value.data.data!!))
                is DataResponse.Fail -> showError?.invoke(value.exception.message.toString())
            }
        }

    fun getDataImageHomeRandom(onSuccess: (LiveData<List<Place>>) -> Unit) = viewModelScope.launch {
        loadingDialog?.invoke()

        when (val value = _placeRepository.getDataImageHomeRandom()) {
            is DataResponse.Success -> onSuccess(MutableLiveData(value.data.data!!))
            is DataResponse.Fail -> showError?.invoke(value.exception.message.toString())
        }
    }

    fun getMenuIngredientFromIdMenu(id: Int, onSuccess: (LiveData<List<IngredientMenu>>) -> Unit) =
        viewModelScope.launch {
            loadingDialog?.invoke()

            when (val value = _placeRepository.getMenuIngredientFromIdMenu(id)) {
                is DataResponse.Success -> onSuccess(MutableLiveData(value.data.data!!))
                is DataResponse.Fail -> showError?.invoke(value.exception.message.toString())
            }
        }

    fun logout(function: () -> Unit) {
        _accountRepository.removeAccountLocal()
        function()
    }
}