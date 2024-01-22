package com.social.tradein.presentation.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.social.tradein.presentation.viewmodel.CoinViewModel

@Composable
fun AppNavigation(viewModel: CoinViewModel) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home"){

        composable("home"){
            HomeCompose(viewModel)
        }
    }

}