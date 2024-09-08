package com.example.appssquaretask.presentation.screens.signup

import androidx.lifecycle.ViewModel
import com.example.appssquaretask.presentation.screens.signup.model.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class SignUpViewModel : ViewModel() {

    private val _userData: MutableStateFlow<UserData> = MutableStateFlow(UserData())
    val userData = _userData

    fun setEmail(email: String) {
        _userData.update {
            it.copy(email = email)
        }
    }

    fun setPassword(password: String) {
        _userData.update {
            it.copy(password = password)
        }
    }

    fun setPhoneNumber(phoneNumber: String) {
        _userData.update {
            it.copy(phoneNumber = phoneNumber)
        }
    }
    fun setCity(city: String) {
        _userData.update {
            it.copy(city = city)
        }
    }
    fun updateTermsState(isAgreeTerms: Boolean) {
        _userData.update {
            it.copy(isAgreeTerms = isAgreeTerms)
        }
    }
}