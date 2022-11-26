package com.example.tastyrecipes.ui.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tastyrecipes.ui.custom_views.EmptySearchView
import com.example.tastyrecipes.ui.custom_views.LoadingView
import com.example.tastyrecipes.ui.custom_views.RecipeCard
import com.example.tastyrecipes.ui.widgets.SearchBar

@ExperimentalComposeUiApi
@Composable
fun SearchScreen() {
    val viewModel = hiltViewModel<SearchViewModel>()
    val uiState = viewModel.uiState.collectAsState()

    Column {
        SearchBar(onClick = { query ->
            viewModel.searchRecipes(query)
        })

        if (uiState.value.isLoading == true) {
            LoadingView()
        } else {
            if (uiState.value.query.isEmpty()) {
                EmptySearchView()
            } else {
                LazyColumn {
                    items(uiState.value.data) { recipe ->
                        RecipeCard(recipe = recipe)
                    }
                }
            }
        }
    }
}


