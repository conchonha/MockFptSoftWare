package com.nhom3.appdulich.data.body.account

data class ChangePasswordBody(val email: String, val password: String, val newPassword: String)