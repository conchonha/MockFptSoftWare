package com.nhom3.appdulich.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.response.DataResponse
import com.nhom3.appdulich.repositories.AccountRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val _accountRepository: AccountRepository,
    private val _application: Application
) : ViewModel() {

    fun getAccount(
        onSuccess: (com.nhom3.appdulich.data.model.Account) -> Unit,
        onFail: (String) -> Unit
    ) = viewModelScope.launch {
        when (val value = _accountRepository.getAccount()) {
            is DataResponse.Success -> onSuccess(value.data)
            is DataResponse.Fail -> onFail(_application.getString(R.string.lbl_account_error_local))
        }
    }

    fun logout(function: () -> Unit) {
        _accountRepository.removeAccountLocal()
        function()
    }
}