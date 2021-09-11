package com.nhom3.appdulich.extension

import android.widget.EditText
import android.widget.ImageView
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.BindingAdapter
import com.nhom3.appdulich.R
import com.nhom3.appdulich.utils.Validations

@BindingAdapter("checkError")
fun checkError(editText: EditText, str: String) {
    val validation = Validations(editText.context)

    editText.doAfterTextChanged {
        editText.error = when (editText.id) {
            R.id.edtEmail -> validation.isEmailValid(it.toString())
            R.id.edtPassword -> validation.isPasswordValid(it.toString())
            R.id.edtName -> validation.isValidName(it.toString())
            else -> null
        }
    }
}



