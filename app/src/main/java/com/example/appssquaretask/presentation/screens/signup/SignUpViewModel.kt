package com.example.appssquaretask.presentation.screens.signup

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appssquaretask.data.model.RegisterResponse
import com.example.appssquaretask.domain.DataState
import com.example.appssquaretask.domain.repository.AuthRepository
import com.example.appssquaretask.presentation.screens.signup.model.UserData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _userData: MutableStateFlow<UserData> = MutableStateFlow(UserData())
    val userData = _userData

    private val _registerState: MutableStateFlow<DataState<RegisterResponse>> =
        MutableStateFlow(DataState.Loading)
    val registerState: StateFlow<DataState<RegisterResponse>> = _registerState




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

    fun signUp() {
        Log.d("HomeViewModel", "${registerState.value}")
        viewModelScope.launch(IO) {
            authRepository.register(
                name = "Ali",
                email = userData.value.email,
                password = userData.value.password,
            ).collect{
                _registerState.value = it
            }
        }
    }
}