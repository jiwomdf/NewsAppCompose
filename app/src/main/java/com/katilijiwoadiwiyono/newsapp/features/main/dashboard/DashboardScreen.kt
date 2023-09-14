package com.katilijiwoadiwiyono.newsapp.features.main.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.katilijiwoadiwiyono.newsapp.common.components.TopBarDashboard
import com.katilijiwoadiwiyono.newsapp.features.main.dashboard.components.ListCardNews
import com.katilijiwoadiwiyono.newsapp.navigation.Screen

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen(
        viewModel = FakeMainViewModel(),
        navController = rememberNavController()
    )
}

@Composable
fun MainScreen(
    viewModel: IMainViewModel,
    navController: NavController,
) {

    val news by remember { viewModel.news }

    LaunchedEffect(Unit) {
        viewModel.getNews()
    }

    Scaffold(
        topBar =  {
            TopBarDashboard()
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding())
                .verticalScroll(rememberScrollState())
        ) {
            for(it in news) {
                ListCardNews(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp),
                    news = it
                ) {
                    navController.navigate(Screen.DetailScreen.route + "/${it.id}")
                }
            }
        }
    }


}
