package com.example.appssquaretask.domain.repository

import com.example.appssquaretask.data.model.CitiesData
import com.example.appssquaretask.domain.DataState
import kotlinx.coroutines.flow.Flow


interface CitiesRepository {
    suspend fun getCities(): Flow<DataState<CitiesData>>
}