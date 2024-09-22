package com.example.appssquaretask.presentation.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appssquaretask.data.model.LoginResponse
import com.example.appssquaretask.domain.DataState
import com.example.appssquaretask.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _loginState: MutableStateFlow<DataState<LoginResponse>> =
        MutableStateFlow(DataState.Loading)
    val loginState: StateFlow<DataState<LoginResponse>> = _loginState

    fun login(email: String, password: String) {
        viewModelScope.launch(IO) {
            authRepository.login(email, password).collect {
                _loginState.value = it
            }
        }
    }
}