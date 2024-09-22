package com.example.appssquaretask.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.appssquaretask.presentation.screens.cityDetails.CityDetails
import com.example.appssquaretask.presentation.screens.commingSoon.ComingSoonScreen
import com.example.appssquaretask.presentation.screens.login.LoginScreen
import com.example.appssquaretask.presentation.screens.login.LoginViewModel
import com.example.appssquaretask.presentation.screens.popularCities.PopularCitiesScreen
import com.example.appssquaretask.presentation.screens.popularCities.PopularCitiesViewModel
import com.example.appssquaretask.presentation.screens.signup.SignUpScreen
import com.example.appssquaretask.presentation.screens.signup.SignUpViewModel
import com.example.appssquaretask.presentation.screens.start.StartScreen

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screens.Start.name) {
        composable(route = Screens.Start.name) {
            StartScreen {
                navController.navigate(Screens.Signup.name)
            }
        }
        composable(route = Screens.Signup.name) {
            val signupViewModel = hiltViewModel<SignUpViewModel>()
            SignUpScreen(
                onClickBack = { navController.popBackStack() },
                signUpViewModel = signupViewModel,
                onSignupClicked = {
                    signupViewModel.signUp()
                },
                registerState = signupViewModel.registerState,
                onSuccessRegister = { navController.navigate(Screens.Login.name) },
                onLoginClicked = { navController.navigate(Screens.Login.name) })

        }
        composable(
            route = Screens.Login.name,
        ) {
            val loginViewModel = hiltViewModel<LoginViewModel>()
            LoginScreen(
                onLoginClicked = { email, password ->
                    loginViewModel.login(email, password)
                },
                onSignupClicked = { navController.navigate(Screens.Signup.name) },
                loginStateFlow = loginViewModel.loginState,
                onSuccessLogin = { navController.navigate(Screens.Home.name) }
            )
        }
        composable(route = Screens.Home.name) {
            val popularCitiesViewModel = hiltViewModel<PopularCitiesViewModel>()
            PopularCitiesScreen(
                onCityClicked = { cityName, cityReviewNum, cityDescription, cityImage ->
                    val encodedCityName = java.net.URLEncoder.encode(cityName, "utf-8")
                    val encodedCityDescription = java.net.URLEncoder.encode(cityDescription, "utf-8")
                    val encodedCityImage = java.net.URLEncoder.encode(cityImage, "utf-8")
                    navController.navigate("${Screens.Details.name}/$encodedCityName/$cityReviewNum/$encodedCityDescription/$encodedCityImage")

                },
                citiesData = popularCitiesViewModel.popularCitiesUiState.value.citiesList
            )
        }
        composable(
            route = "${Screens.Details.name}/{cityName}/{cityReviewNum}/{cityDescription}/{cityImage}",
            arguments = listOf(navArgument("cityName") { type = NavType.StringType },
                navArgument("cityReviewNum") { type = NavType.IntType },
                navArgument("cityDescription") { type = NavType.StringType },
                navArgument("cityImage") { type = NavType.StringType })
        ) { backStackEntry ->
            val cityName =
                java.net.URLDecoder.decode(backStackEntry.arguments?.getString("cityName"), "utf-8")
            val cityDescription = java.net.URLDecoder.decode(
                backStackEntry.arguments?.getString("cityDescription"),
                "utf-8"
            )
            val cityImage = java.net.URLDecoder.decode(
                backStackEntry.arguments?.getString("cityImage"),
                "utf-8"
            )
            val cityReviewNum = backStackEntry.arguments?.getInt("cityReviewNum")

            CityDetails(
                name = cityName ?: "",
                reviewsNum = cityReviewNum ?: 0,
                description = cityDescription ?: "",
                image = cityImage ?: "",
                onBackClicked = { navController.popBackStack() })
        }
        composable(route = Screens.ComingSoon.name) {
            ComingSoonScreen(onRefreshClicked = {})
        }

    }
}