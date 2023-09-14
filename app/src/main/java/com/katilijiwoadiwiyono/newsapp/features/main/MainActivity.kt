package com.katilijiwoadiwiyono.newsapp.features.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.katilijiwoadiwiyono.newsapp.common.components.StatusBarColor
import com.katilijiwoadiwiyono.newsapp.common.components.ThemeState
import com.katilijiwoadiwiyono.newsapp.features.main.dashboard.MainViewModel
import com.katilijiwoadiwiyono.newsapp.theme.RecordAppTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModel<MainViewModel>()
    private val sharedViewModel by viewModel<MainSharedViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecordAppTheme(
                isUseDarkTheme = ThemeState.darkModeState.value
            ) {
                StatusBarColor(color = MaterialTheme.colorScheme.primary)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    MainNavigation(
                        mainViewModel = mainViewModel,
                        sharedViewModel= sharedViewModel
                    )
                }
            }
        }

    }
}