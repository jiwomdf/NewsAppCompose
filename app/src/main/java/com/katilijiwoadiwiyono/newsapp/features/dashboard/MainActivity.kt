package com.katilijiwoadiwiyono.newsapp.features.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.katilijiwoadiwiyono.newsapp.navigation.Screen
import com.katilijiwoadiwiyono.newsapp.theme.RecordAppTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()

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
                        startDestination = Screen.Screen1.route
                    ) {
                        composable(route = Screen.Screen1.route) {
                            MainScreen(viewModel)
                        }
                        composable(route = Screen.Screen2.route) {

                        }
                        composable(route = Screen.Screen3.route) {

                        }
                    }
                }
            }
        }

    }
}