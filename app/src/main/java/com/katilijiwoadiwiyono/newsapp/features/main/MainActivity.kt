package com.katilijiwoadiwiyono.newsapp.features.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.katilijiwoadiwiyono.newsapp.features.main.dashboard.MainScreen
import com.katilijiwoadiwiyono.newsapp.features.main.dashboard.MainViewModel
import com.katilijiwoadiwiyono.newsapp.features.main.detail.DetailScreen
import com.katilijiwoadiwiyono.newsapp.navigation.Screen
import com.katilijiwoadiwiyono.newsapp.theme.RecordAppTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModel<MainViewModel>()
    private val sharedViewModel by viewModel<MainSharedViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecordAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.DashboardScreen.route
                    ) {
                        with(Screen.DashboardScreen) {
                            composable(route = route) {
                                MainScreen(mainViewModel, sharedViewModel, navController)
                            }
                        }
                        with(Screen.DetailScreen) {
                            composable(route = route) {
                                val newsModel = sharedViewModel.newsModel
                                DetailScreen(newsModel)
                            }
                        }
                    }
                }
            }
        }

    }
}