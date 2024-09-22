package com.example.appssquaretask.presentation.screens.popularCities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appssquaretask.data.model.CitiesData
import com.example.appssquaretask.domain.DataState
import com.example.appssquaretask.domain.repository.CitiesRepository
import com.example.appssquaretask.presentation.screens.popularCities.model.PopularCitiesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularCitiesViewModel @Inject constructor(
    private val citiesRepository: CitiesRepository
) : ViewModel() {
    private val citiesState: MutableStateFlow<DataState<CitiesData>> =
        MutableStateFlow(DataState.Loading)
    val citiesData: StateFlow<DataState<CitiesData>> = citiesState

    private val _popularCitiesUiState: MutableStateFlow<PopularCitiesUiState> =
        MutableStateFlow(PopularCitiesUiState())
    val popularCitiesUiState = _popularCitiesUiState

    init {
        getCities()
    }

    private fun getCities() {
        viewModelScope.launch {
            citiesRepository.getCities().collect { res ->
                citiesState.value = res
                when (res) {
                    is DataState.Success -> {
                        _popularCitiesUiState.update {
                            it.copy(
                                citiesList = res.data.data
                            )
                        }
                    }

                    else -> {}
                }
            }
        }

    }
}