package com.katilijiwoadiwiyono.newsapp.navigation

sealed class Screen(val route: String) {
    object Screen1: Screen("screen_1")
    object Screen2: Screen("screen_2")
    object Screen3: Screen("screen_3")
}