package com.nhom3.appdulich.viewmodel.account

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.response.DataResponse
import com.nhom3.appdulich.repositories.AccountRepository
import com.nhom3.appdulich.utils.Validations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

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

    fun register(success: () -> Unit){
        checkEmail {
            registerAccount(success)
        }
    }

    private fun registerAccount(onSuccess: () -> Unit) = viewModelScope.launch {
        _validations.register(
            name.value.toString(),
            email.value.toString(),
            password.value.toString()
        )?.let { registerBody ->
            loadingDialog?.invoke()
            when (val value = _repository.register(registerBody)) {
                is DataResponse.Success ->
                    when (value.data.statuscode) {
                        200 -> {
                            Log.d("AAA", "success: ")
                            _repository.saveAccount(value.data.data!!)
                            onSuccess()
                        }
                        else -> {
                            Log.d("AAA", "registerAccount: ${value.data.message.toString()}")
                            showError?.invoke(value.data.message.toString())
                        }
                    }

                is DataResponse.Fail -> showError?.invoke(value.exception.message.toString())
            }
        } ?: showError?.invoke(_application.getString(R.string.lbl_account_error))
    }

    private fun checkEmail(onSuccess: (Int) -> Unit) = viewModelScope.launch {
        loadingDialog?.invoke()
        val verifyCode = Random.nextInt(10000000)

        val data = _repository.sendVerifyMail(
            email = email.value.toString(),
            _application.getString(R.string.lbl_verify_account),
            verifyCode.toString()
        )
        when (data) {
            is DataResponse.Success -> onSuccess(verifyCode)
            is DataResponse.Fail -> showError?.invoke(data.exception.message.toString())
        }
    }
}

