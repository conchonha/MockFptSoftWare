package com.nhom3.appdulich.data.body.account

data class UpdateProfileBody(
    val id: String,
    val name: String,
    val email: String,
    val phone: String,
    val age: String,
    val gender: String
)