package com.nhom3.appdulich.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nhom3.appdulich.R
import com.nhom3.appdulich.repositories.AccountRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VerifyViewModel @Inject constructor(
    private val _repository: AccountRepository,
    private val _context: Application
) : ViewModel() {
    val textCode = MutableLiveData<String>()

    var showError: ((String) -> Unit)? = null

    fun verifyCode(strCode: String,email : String, onSuccess: () -> Unit) {
        if (strCode != "" && strCode == textCode.value.toString() && email != "") {
            onSuccess()
            return
        }
        showError?.invoke(_context.getString(R.string.lbl_error_verify_code))
    }
}