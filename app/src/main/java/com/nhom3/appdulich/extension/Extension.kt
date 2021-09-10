package com.nhom3.appdulich.extension

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.BindingAdapter
import androidx.navigation.Navigation
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

@BindingAdapter("confirm_password")
fun confirmPassword(editText: EditText, str: String) {
    val validation = Validations(editText.context)

    editText.doAfterTextChanged {
        editText.error = validation.isConfirmPass(it.toString(), str)
    }
}

fun View.navigate(action: Int, bundle: Bundle? = null) {
    Navigation.findNavController(this).navigate(action,bundle)
}

fun Toolbar.setUpToolbar(icon : Int? = null, onclick:()->Unit){
    setNavigationIcon(icon ?: R.drawable.ic_back)
    setNavigationOnClickListener {
        onclick()
    }
}

