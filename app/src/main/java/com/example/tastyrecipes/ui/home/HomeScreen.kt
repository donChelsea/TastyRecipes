package com.example.tastyrecipes.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tastyrecipes.ui.custom_views.LoadingView
import com.example.tastyrecipes.ui.custom_views.RecipeCard
import com.example.tastyrecipes.ui.navigation.NavigationItem
import com.example.tastyrecipes.ui.widgets.Carousel
import com.example.tastyrecipes.ui.widgets.SectionContainer
import com.example.tastyrecipes.utils.TRENDING_FEED

@ExperimentalComposeUiApi
@Composable
fun HomeScreen(
    navController: NavController
) {
    val viewModel = hiltViewModel<HomeViewModel>()
    val uiState = viewModel.uiState.collectAsState()

    if (uiState.value.isLoading == true) {
        LoadingView()
    } else {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            SectionContainer(title = TRENDING_FEED) {
                uiState.value.data.let { feed ->
                    feed?.let {
                        Carousel {
                            items(feed.items) { recipe ->
                                RecipeCard(
                                    recipe = recipe,
                                    onClick = { navController.navigate("${NavigationItem.RecipeDetail.route}/$it") }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}