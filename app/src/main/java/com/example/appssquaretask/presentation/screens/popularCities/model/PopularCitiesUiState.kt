package com.example.appssquaretask.presentation.screens.popularCities.model

import com.example.appssquaretask.data.model.Restaurant

data class PopularCitiesUiState(
    val citiesList : List<Restaurant> = emptyList(),
)
