package com.example.appssquaretask.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.appssquaretask.R

data class CityData(
    val name: String,
    val reviewsNum: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int
)

val citiesList = listOf(
    CityData(
        name = "Coeurdes Alpes ",
        image = R.drawable.first_img,
        reviewsNum = 355,
        description = R.string.city_description,
    ),
    CityData(
        name = "Coeurdes Alpes ",
        image = R.drawable.second_img,
        reviewsNum = 355,
        description = R.string.city_description,
    ),
    CityData(
        name = "Coeurdes Alpes ",
        image = R.drawable.third_img,
        reviewsNum = 355,
        description = R.string.city_description,
    ),
)
