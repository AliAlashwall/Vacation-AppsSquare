package com.example.appssquaretask.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.appssquaretask.R


val Hiatus = FontFamily(
    Font(R.font.hiatus, FontWeight.Normal)
)


val Typography = Typography(

    displayLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 46.sp,
        fontWeight = FontWeight(600)
    ),

    displaySmall = TextStyle(
        fontFamily = Hiatus,
        fontSize = 46.sp,
        fontWeight = FontWeight(400)
    ),
    headlineLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 36.sp,
        fontWeight = FontWeight(600)
    ),
    headlineSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 36.sp,
        fontWeight = FontWeight(400)
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 26.sp,
        fontWeight = FontWeight(600)
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 26.sp,
        fontWeight = FontWeight(500)
    ),
    titleSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 26.sp,
        fontWeight = FontWeight(400)
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 16.sp,
        fontWeight = FontWeight(600)
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 16.sp,
        fontWeight = FontWeight(500)
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 16.sp,
        fontWeight = FontWeight(400)
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 12.sp,
        fontWeight = FontWeight(600)
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 12.sp,
        fontWeight = FontWeight(500)
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 12.sp,
        fontWeight = FontWeight(400)
    )
)

/*
46 display
36 headline
26 title
16 body
14 label*/