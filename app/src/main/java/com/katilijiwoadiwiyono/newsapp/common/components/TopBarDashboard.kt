package com.katilijiwoadiwiyono.newsapp.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.katilijiwoadiwiyono.newsapp.R

@Preview
@Composable
fun TopBarDashboardPreview() {
    TopBarDashboard()
}

@Composable
fun TopBarDashboard() {
    val isDark = ThemeState.darkModeState.value

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(
            modifier = Modifier.padding(start = 20.dp)
        )
        Image(
            modifier = Modifier
                .width(200.dp),
            painter = painterResource(id = R.drawable.ic_celebrities_id),
            contentDescription = "",
        )
        val icResource = if(isDark) R.drawable.ic_dark_theme_on_24 else R.drawable.ic_dark_theme_off_24
        Image(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(end = 16.dp)
                .height(50.dp)
                .clickable {
                    setToggleTheme(isDark)
                },
            painter = painterResource(id = icResource),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
    }
}