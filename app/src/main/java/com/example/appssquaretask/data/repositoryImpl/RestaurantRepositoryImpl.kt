package com.example.appssquaretask.data.repositoryImpl

import com.example.appssquaretask.data.model.CitiesData
import com.example.appssquaretask.data.remote.RetrofitServices
import com.example.appssquaretask.domain.DataState
import com.example.appssquaretask.domain.reformatingApi
import com.example.appssquaretask.domain.repository.CitiesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CitiesRepositoryImpl @Inject constructor(
    private val apiService: RetrofitServices
) : CitiesRepository {
    override suspend fun getCities(): Flow<DataState<CitiesData>> =
        reformatingApi { apiService.citiesList()}
}