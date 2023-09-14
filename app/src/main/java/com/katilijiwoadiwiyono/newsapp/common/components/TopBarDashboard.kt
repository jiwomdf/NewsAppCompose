package com.katilijiwoadiwiyono.newsapp.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 16.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        Image(
            modifier = Modifier
                .width(200.dp),
            painter = painterResource(id = R.drawable.ic_celebrities_id),
            contentDescription = "",
        )
    }
}