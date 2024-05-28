package com.example.littlelemonprojectfinal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController,paddingValues: PaddingValues) {
    Column(
        Modifier.padding(paddingValues)
    ) {
        TopAppBar()
        UpperPanel()
        LowerPanel(navController, DishRepository.dishes)
    }
}