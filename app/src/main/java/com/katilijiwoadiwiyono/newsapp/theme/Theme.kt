package com.programmergabut.recordapp.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.katilijiwoadiwiyono.newsapp.theme.md_theme_dark_onPrimary
import com.katilijiwoadiwiyono.newsapp.theme.md_theme_dark_onPrimaryContainer
import com.katilijiwoadiwiyono.newsapp.theme.md_theme_dark_primary
import com.katilijiwoadiwiyono.newsapp.theme.md_theme_dark_primaryContainer
import com.katilijiwoadiwiyono.newsapp.theme.md_theme_light_onPrimary
import com.katilijiwoadiwiyono.newsapp.theme.md_theme_light_onPrimaryContainer
import com.katilijiwoadiwiyono.newsapp.theme.md_theme_light_primary
import com.katilijiwoadiwiyono.newsapp.theme.md_theme_light_primaryContainer

private val DarkColorPalette = darkColorScheme(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    primaryContainer = md_theme_light_primaryContainer,
    onPrimaryContainer = md_theme_light_onPrimaryContainer
)

private val LightColorPalette = lightColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    primaryContainer = md_theme_dark_primaryContainer,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer,
)

@Composable
fun RecordAppTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (!useDarkTheme) LightColorPalette else DarkColorPalette
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = MaterialTheme.shapes,
        content = content
    )
}