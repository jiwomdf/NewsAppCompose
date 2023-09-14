package com.katilijiwoadiwiyono.newsapp.common.components

import androidx.appcompat.app.AppCompatDelegate


fun setToggleTheme(isDark: Boolean) {
    val theme = when(isDark){
        true -> AppCompatDelegate.MODE_NIGHT_NO
        false -> AppCompatDelegate.MODE_NIGHT_YES
    }
    AppCompatDelegate.setDefaultNightMode(theme)
    ThemeState.darkModeState.value = !isDark
}