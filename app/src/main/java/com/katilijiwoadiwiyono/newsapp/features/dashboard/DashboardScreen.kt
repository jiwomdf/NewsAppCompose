package com.katilijiwoadiwiyono.newsapp.features.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.katilijiwoadiwiyono.newsapp.common.components.TopBarCenter
import com.katilijiwoadiwiyono.newsapp.features.dashboard.components.ListCardNews

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen(
        viewModel = FakeMainViewModel()
    )
}

@Composable
fun MainScreen(
    viewModel: IMainViewModel
) {

    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.getNews()
    }

    Scaffold(
        topBar =  {
            TopBarCenter()
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding())
                .verticalScroll(rememberScrollState())
        ) {
            repeat(50) {
                ListCardNews(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                )
            }
        }
    }


}
