package com.example.appssquaretask.data.repositoryImpl

import com.example.appssquaretask.data.model.LoginResponse
import com.example.appssquaretask.data.model.RegisterResponse
import com.example.appssquaretask.data.remote.RetrofitServices
import com.example.appssquaretask.domain.DataState
import com.example.appssquaretask.domain.reformatingApi
import com.example.appssquaretask.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow

class AuthRepositoryImpl(private val retrofitServices: RetrofitServices) : AuthRepository {

    override suspend fun login(email: String, password: String): Flow<DataState<LoginResponse>> =
        reformatingApi { retrofitServices.login(email, password) }

    override suspend fun register(
        name: String,
        email: String,
        password: String
    ): Flow<DataState<RegisterResponse>> =
        reformatingApi { retrofitServices.register(name, email, password) }
}
