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
import com.programmergabut.recordapp.navigation.Screen
import com.programmergabut.recordapp.theme.RecordAppTheme

class MainActivity : AppCompatActivity() {
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
                            MainScreen()
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