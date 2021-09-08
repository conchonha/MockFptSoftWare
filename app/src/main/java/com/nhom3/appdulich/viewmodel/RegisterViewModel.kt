package com.nhom3.appdulich.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nhom3.appdulich.data.body.RegisterBody
import com.nhom3.appdulich.repositories.AccountRepository
import com.nhom3.appdulich.utils.Validations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: AccountRepository,
    private val validations: Validations
) : BaseViewModel() {
    val name = MutableLiveData("")
    val email = MutableLiveData("")
    val password = MutableLiveData("")

    fun register() = viewModelScope.launch(Dispatchers.Main) {
        if (validations.isValidName(name.value.toString()) == null &&
            validations.isPasswordValid(password.value.toString()) == null &&
            validations.isEmailValid(email.value.toString()) == null
        ) {
            val body = RegisterBody(
                name.value.toString(),
                email.value.toString(),
                password.value.toString()
            )
        }
    }
}