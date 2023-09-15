package com.katilijiwoadiwiyono.newsapp.features.main.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.katilijiwoadiwiyono.newsapp.common.components.TopBarDashboard
import com.katilijiwoadiwiyono.newsapp.features.main.FakeSharedViewModel
import com.katilijiwoadiwiyono.newsapp.features.main.IMainSharedViewModel
import com.katilijiwoadiwiyono.newsapp.features.main.dashboard.components.ListCardNews
import com.katilijiwoadiwiyono.newsapp.features.main.navigation.Screen
import kotlinx.coroutines.launch

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen(
        viewModel = FakeMainViewModel(),
        sharedViewModel = FakeSharedViewModel(),
        navController = rememberNavController()
    )
}

@Composable
fun MainScreen(
    viewModel: IMainViewModel,
    sharedViewModel: IMainSharedViewModel,
    navController: NavController,
) {
    val context = LocalContext.current
    val snackBarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    val news by remember { viewModel.news }
    val commonError by remember { viewModel.commonError }

    LaunchedEffect(Unit) {
        viewModel.getNews()
    }

    LaunchedEffect(commonError) {
        if (commonError != 0 && news.isEmpty()) {
            coroutineScope.launch {
                snackBarHostState.showSnackbar(
                    message = context.getString(commonError),
                    duration = SnackbarDuration.Short
                )
            }
        }
    }

    Scaffold(
        topBar =  {
            TopBarDashboard()
        },
        snackbarHost = {
            SnackbarHost(snackBarHostState)
        },
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding()),
            verticalArrangement = Arrangement.Center
        ) {
            val isLoading = news.isEmpty() && commonError == 0
            if(isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            } else {
                LazyColumn {
                    items(news.size) { idx ->
                        val item = news[idx]
                        ListCardNews(
                            modifier = Modifier
                                .padding(start = 16.dp, end = 16.dp),
                            news = item
                        ) {
                            sharedViewModel.setNewsModel(item)
                            navController.navigate(Screen.DetailScreen.route)
                        }
                    }
                }
            }
        }
    }


}
