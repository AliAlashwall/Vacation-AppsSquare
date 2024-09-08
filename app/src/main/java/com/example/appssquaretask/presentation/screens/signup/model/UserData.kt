package com.example.appssquaretask.presentation.screens.signup.model

data class UserData(
    val email: String = "",
    val password: String = "",
    val phoneNumber: String = "",
    val city: String = "",
    val isAgreeTerms: Boolean = false
)
