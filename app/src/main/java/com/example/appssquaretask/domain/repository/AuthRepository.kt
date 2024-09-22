package com.example.appssquaretask.domain.repository

import com.example.appssquaretask.data.model.LoginResponse
import com.example.appssquaretask.data.model.RegisterResponse
import com.example.appssquaretask.domain.DataState
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    suspend fun login(email: String, password: String): Flow<DataState<LoginResponse>>

    suspend fun register(
        name: String,
        email: String,
        password: String,
    ): Flow<DataState<RegisterResponse>>

}