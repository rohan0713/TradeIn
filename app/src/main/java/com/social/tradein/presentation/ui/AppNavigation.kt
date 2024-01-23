package com.social.tradein.presentation.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.social.tradein.presentation.viewmodel.CoinViewModel

@Composable
fun AppNavigation(viewModel: CoinViewModel) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash"){

        composable("splash"){
            SplashScreenCompose(){
                navController.navigate("home")
            }
        }
        composable("home"){
            HomeCompose(viewModel, navController)
        }

        composable("chart/{id}", arguments = listOf(
            navArgument("id") {
                type = NavType.StringType
            }
        )){
            val id = it.arguments?.getString("id")
            ChartScreenCompose(viewModel, id)
        }
    }

}