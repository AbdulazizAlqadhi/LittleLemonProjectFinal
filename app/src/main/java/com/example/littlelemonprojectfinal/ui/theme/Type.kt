package com.example.littlelemonprojectfinal.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    headlineLarge = TextStyle(
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
        color = LittleLemonFinalProjectColor.charcoal
    ),
    headlineMedium = TextStyle(
        color = LittleLemonFinalProjectColor.charcoal,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    ),
    bodyLarge = TextStyle(
        color = LittleLemonFinalProjectColor.green
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        color = LittleLemonFinalProjectColor.green
    ),
    labelMedium = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
    )
    //TODO: Insert code here
)