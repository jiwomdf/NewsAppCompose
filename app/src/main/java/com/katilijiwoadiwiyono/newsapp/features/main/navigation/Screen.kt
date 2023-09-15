package com.katilijiwoadiwiyono.newsapp.features.main.navigation

sealed class Screen(val route: String) {
    object DashboardScreen: Screen("dashboard_screen")
    object DetailScreen: Screen("detail_screen")
}