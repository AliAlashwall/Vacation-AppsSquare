package com.example.appssquaretask.presentation.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.appssquaretask.data.model.citiesList
import com.example.appssquaretask.presentation.screens.cityDetails.CityDetails
import com.example.appssquaretask.presentation.screens.commingSoon.ComingSoonScreen
import com.example.appssquaretask.presentation.screens.popularCities.PopularCitiesScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screens.Home.name) {

        composable(route = Screens.Home.name) {
            PopularCitiesScreen(onCityClicked = { cityIndex ->
                navController.navigate("${Screens.Details.name}/$cityIndex")
            })
        }
        composable(
            route = "${Screens.Details.name}/{cityIndex}",
            arguments = listOf(navArgument("cityIndex") { type = NavType.IntType })
        ) { backStackEntry ->
            val cityIndex = backStackEntry.arguments?.getInt("cityIndex")
            val cityData = citiesList[cityIndex ?: 0]
            CityDetails(cityData = cityData, onBackClicked = { navController.popBackStack() })
        }
        composable(route = Screens.ComingSoon.name) {
            ComingSoonScreen(onRefreshClicked = {})
        }

    }
}