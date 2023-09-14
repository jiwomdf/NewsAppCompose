package com.katilijiwoadiwiyono.newsapp.features.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.katilijiwoadiwiyono.newsapp.features.main.dashboard.MainScreen
import com.katilijiwoadiwiyono.newsapp.features.main.dashboard.MainViewModel
import com.katilijiwoadiwiyono.newsapp.features.main.detail.DetailScreen
import com.katilijiwoadiwiyono.newsapp.navigation.Screen

@Composable
fun MainNavigation(
    mainViewModel: MainViewModel,
    sharedViewModel: MainSharedViewModel
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.DashboardScreen.route
    ) {
        with(Screen.DashboardScreen) {
            composable(route = route) {
                MainScreen(mainViewModel, sharedViewModel, navController)
            }
        }
        with(Screen.DetailScreen) {
            composable(route = route) {
                val newsModel = sharedViewModel.newsModel
                DetailScreen(newsModel)
            }
        }
    }
}