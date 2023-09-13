package com.katilijiwoadiwiyono.newsapp.features.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.katilijiwoadiwiyono.core.domain.model.NewsModel
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

    val news by remember { viewModel.news }

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
            for(it in news) {
                ListCardNews(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp),
                    news = it
                )
            }
        }
    }


}
