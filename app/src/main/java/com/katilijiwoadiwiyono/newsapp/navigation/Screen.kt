package com.katilijiwoadiwiyono.newsapp.navigation

sealed class Screen(val route: String) {
    object DashboardScreen: Screen("dashboard_screen")
    object DetailScreen: Screen("detail_screen"){
        const val newsId = "news_id"
    }
}