package com.example.tastyrecipes.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tastyrecipes.ui.MainViewModel
import com.example.tastyrecipes.ui.custom_views.LoadingView

@Composable
fun HomeScreen() {
    val viewModel = hiltViewModel<MainViewModel>()
    val uiState = viewModel.uiState.collectAsState()

    if (uiState.value.isLoading == true) {
        LoadingView()
    } else {

    }


}