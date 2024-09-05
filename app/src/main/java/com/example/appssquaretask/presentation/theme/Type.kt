package com.example.appssquaretask.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.appssquaretask.R


val Abel = FontFamily(
    Font(R.font.abel, FontWeight.Normal)
)

val Typography = Typography(

    displayLarge = TextStyle(
        fontFamily = Abel,
        fontSize = 46.sp,
        fontWeight = FontWeight(600)
    ),
    displaySmall = TextStyle(
        fontFamily = Abel,
        fontSize = 46.sp,
        fontWeight = FontWeight(400)
    ),
    headlineLarge = TextStyle(
        fontFamily = Abel,
        fontSize = 36.sp,
        fontWeight = FontWeight(600)
    ),
    headlineSmall = TextStyle(
        fontFamily = Abel,
        fontSize = 36.sp,
        fontWeight = FontWeight(400)
    ),
    titleLarge = TextStyle(
        fontFamily = Abel,
        fontSize = 26.sp,
        fontWeight = FontWeight(600)
    ),
    titleMedium = TextStyle(
        fontFamily = Abel,
        fontSize = 26.sp,
        fontWeight = FontWeight(500)
    ),
    titleSmall = TextStyle(
        fontFamily = Abel,
        fontSize = 26.sp,
        fontWeight = FontWeight(400)
    ),
    bodyLarge = TextStyle(
        fontFamily = Abel,
        fontSize = 16.sp,
        fontWeight = FontWeight(600)
    ),
    bodyMedium = TextStyle(
        fontFamily = Abel,
        fontSize = 16.sp,
        fontWeight = FontWeight(500)
    ),
    bodySmall = TextStyle(
        fontFamily = Abel,
        fontSize = 16.sp,
        fontWeight = FontWeight(400)
    ),
    labelLarge = TextStyle(
        fontFamily = Abel,
        fontSize = 14.sp,
        fontWeight = FontWeight(600)
    ),
    labelMedium = TextStyle(
        fontFamily = Abel,
        fontSize = 14.sp,
        fontWeight = FontWeight(500)
    ),
    labelSmall = TextStyle(
        fontFamily = Abel,
        fontSize = 14.sp,
        fontWeight = FontWeight(400)
    )
)

/*
46 display
36 headline
26 title
16 body
14 label*/