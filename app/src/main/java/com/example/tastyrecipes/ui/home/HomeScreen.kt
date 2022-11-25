package com.example.tastyrecipes.ui.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tastyrecipes.ui.MainViewModel
import com.example.tastyrecipes.ui.custom_views.LoadingScreen
import com.example.tastyrecipes.ui.custom_views.TextCard

@Composable
fun HomeScreen() {
    val viewModel = hiltViewModel<MainViewModel>()
    val uiState = viewModel.uiState.collectAsState()

    if (uiState.value.isLoading == true) {
        LoadingScreen()
    } else {
        LazyColumn {
            items(uiState.value.recipes) { recipe ->
                TextCard(recipe = recipe)
            }
        }
    }


}