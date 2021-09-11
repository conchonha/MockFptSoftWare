package com.nhom3.appdulich.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.response.DataResponse
import com.nhom3.appdulich.repositories.AccountRepository
import com.nhom3.appdulich.utils.Validations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val _repository: AccountRepository,
    private val _validations: Validations,
    private val _application: Application
) : ViewModel() {
    var loadingDialog: (() -> Unit)? = null
    var showError: ((String) -> Unit)? = null

    val name = MutableLiveData("")
    val email = MutableLiveData("")
    val password = MutableLiveData("")

    fun register(success: () -> Unit) = viewModelScope.launch(Dispatchers.Main) {
        _validations.register(
            name.value.toString(),
            password.value.toString(),
            email.value.toString()
        )?.let {
            loadingDialog?.invoke()
            when (val value = _repository.register(it)) {
                is DataResponse.Success -> {
                    when (value.data.statuscode) {
                        200 -> {
                            success()
                            _repository.saveAccount(value.data.data!!)
                        }
                        else -> showError?.invoke(value.data.message.toString())
                    }
                }
                is DataResponse.Fail -> showError?.invoke(value.exception.message.toString())
            }
        } ?: showError?.invoke(_application.getString(R.string.lbl_account_error))
    }
}