package com.nhom3.appdulich.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nhom3.appdulich.data.body.LoginBody
import com.nhom3.appdulich.data.model.Account
import com.nhom3.appdulich.repositories.AccountRepository
import com.nhom3.appdulich.utils.Validations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val _validation: Validations,
    private val _repository: AccountRepository,
) : BaseViewModel() {


    val email = MutableLiveData("")
    val password = MutableLiveData("")

    fun login() = viewModelScope.launch(Dispatchers.Main) {
        if (_validation.isEmailValid(email.value.toString()) == null &&
            _validation.isPasswordValid(password.value.toString()) == null
        ) {
            loadingDialog.value = true
            dataResponse.value = _repository.login(
                LoginBody(
                    email.value.toString(),
                    password.value.toString()
                )
            )
        }
    }

    fun saveAccount(account: Account) = _repository.saveAccount(account)

    fun checkAccount(action: () -> Unit) {
        if (_repository.checkAccount()) {
            action()
        }
    }
}