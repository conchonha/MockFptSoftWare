package com.nhom3.appdulich.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nhom3.appdulich.R
import com.nhom3.appdulich.base.response.DataResponse
import com.nhom3.appdulich.data.body.LoginBody
import com.nhom3.appdulich.data.body.NewPasswordBody
import com.nhom3.appdulich.repositories.AccountRepository
import com.nhom3.appdulich.utils.Validations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val _validation: Validations,
    private val _repository: AccountRepository,
    private val _context: Application
) : ViewModel() {
    var loadingDialog: (() -> Unit)? = null
    var showError: ((String) -> Unit)? = null

    //login fragment
    val email = MutableLiveData("")
    val password = MutableLiveData("")

    //verify account fragment
    val textCode = MutableLiveData("")
    private var _verifyCode: Int? = null

    //new password fragment
    val passwordNewPass = MutableLiveData("")
    val confirmPassNewPass = MutableLiveData("")


    fun login(success: () -> Unit) = viewModelScope.launch {
        if (_validation.isEmailValid(email.value.toString()) == null &&
            _validation.isPasswordValid(password.value.toString()) == null
        ) {
            loadingDialog?.invoke()
            val loginBody = LoginBody(
                email.value.toString(),
                password.value.toString()
            )
            when (val value = _repository.login(loginBody)) {
                is DataResponse.Success -> {
                    when (value.data.statuscode) {
                        200 -> {
                            success()
                            _repository.saveAccount(value.data.data?.get(0)!!)
                        }
                        else -> showError?.invoke(value.data.message!!)
                    }
                }
                is DataResponse.Fail -> showError?.invoke(value.exception.message.toString())
            }
        }
    }

    fun sendVerifyMail(onSuccess: () -> Unit) = viewModelScope.launch {
        if (_validation.isEmailValid(email.value.toString()) == null) {
            loadingDialog?.invoke()
            _verifyCode = Random.nextInt(10000000)

            val data = _repository.sendVerifyMail(
                email = email.value.toString(),
                _context.getString(R.string.lbl_verify_account),
                _verifyCode.toString()
            )
            when (data) {
                is DataResponse.Success -> {
                    when (val value = _repository.checkMailAccount(email.value.toString())) {
                        is DataResponse.Success -> {
                            when (value.data.statuscode) {
                                200 -> onSuccess()
                                else -> showError?.invoke(value.data.message.toString())
                            }
                        }
                        is DataResponse.Fail -> showError?.invoke(value.exception.message.toString())
                    }
                }
                is DataResponse.Fail -> showError?.invoke(data.exception.message.toString())
            }
        } else {
            showError?.invoke(_context.getString(R.string.lbl_error_email))
        }
    }

    fun checkAccount(action: () -> Unit) {
        if (_repository.checkAccount()) {
            action()
        }
    }

    //verify account fragment
    fun verifyCode(onSuccess: () -> Unit) = viewModelScope.launch {
        if (_verifyCode != null) {
            if (textCode.value.toString() == _verifyCode.toString()) {
                onSuccess()
                return@launch
            }
        }
        showError?.invoke(_context.getString(R.string.lbl_error_verify_code))
    }

    //new password fragment
    fun newPassword(onSuccess: () -> Unit) = viewModelScope.launch {
        val passwordNewPass = passwordNewPass.value.toString()
        val confirmPass = confirmPassNewPass.value.toString()

        if (_validation.isPasswordValid(passwordNewPass) == null &&
            _validation.isConfirmPass(passwordNewPass, confirmPass) == null
        ) {
            loadingDialog?.invoke()
            val passwordBody = NewPasswordBody(email.value.toString(), passwordNewPass)

            when (val value = _repository.newPassword(passwordBody)) {
                is DataResponse.Success -> {
                    when (value.data.statuscode) {
                        200 -> onSuccess()
                        else -> showError?.invoke(value.data.message.toString())
                    }
                }
                is DataResponse.Fail -> showError?.invoke(value.exception.message.toString())
            }
            return@launch
        }
        showError?.invoke(_context.getString(R.string.lbl_account_error))
    }
}