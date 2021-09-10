package com.nhom3.appdulich.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nhom3.appdulich.base.response.DataResponse
import com.nhom3.appdulich.repositories.AccountRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val _repository: AccountRepository) :
    ViewModel() {
    var showError: ((String) -> Unit)? = null

    val email = MutableLiveData("")
    val phone = MutableLiveData("")
    val age = MutableLiveData("")
    val gender = MutableLiveData("")
    val name = MutableLiveData("")

    fun getAccount() = viewModelScope.launch {
        when (val value = _repository.getAccount()) {
            is DataResponse.Success -> {
                val account = value.data
                withContext(Dispatchers.Main) {
                    email.value = account.email
                    phone.value = account.phone
                    age.value = account.age.toString()
                    gender.value = account.gender.toString()
                    name.value = account.name
                }
            }
            is DataResponse.Fail -> showError?.invoke(value.exception.message.toString())
        }
    }
}