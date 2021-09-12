package com.nhom3.appdulich.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nhom3.appdulich.utils.Validations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val _validation : Validations
) : ViewModel(){
    fun isPermissionGrand(array: Array<String>) = _validation.isPermissionGrand(array)

    fun isGpsStatus() = _validation.checkGpsStatus()
}