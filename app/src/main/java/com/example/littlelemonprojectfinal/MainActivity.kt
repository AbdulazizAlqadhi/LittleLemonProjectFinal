package com.example.littlelemonprojectfinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.littlelemonprojectfinal.ui.theme.LittleLemonProjectFinalTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonProjectFinalTheme {
                Scaffold { paddingValues ->
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Home.route) {
                        composable(Home.route) {
                            HomeScreen(navController, paddingValues)
                        }
                        composable(
                            DishDetails.route + "/{${DishDetails.argDishId}}",
                            arguments = listOf(navArgument(DishDetails.argDishId) { type = NavType.IntType })
                        ) {
                            val id = requireNotNull(it.arguments?.getInt(DishDetails.argDishId)) { "Dish id is null" }
                            DishDetails(id, navController, paddingValues)
                        }
                    }
                }
            }
        }
    }
}