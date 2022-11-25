package com.example.tastyrecipes.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tastyrecipes.ui.MainViewModel
import com.example.tastyrecipes.ui.custom_views.LoadingView
import com.example.tastyrecipes.ui.custom_views.TextCard
import com.example.tastyrecipes.ui.theme.Purple700
import com.example.tastyrecipes.ui.widgets.Carousel
import com.example.tastyrecipes.ui.widgets.SectionContainer
import com.example.tastyrecipes.utils.TRENDING_FEED

@Composable
fun HomeScreen() {
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
                            items(feed.items) { item ->
                                TextCard(recipe = item)
                            }
                        }
                    }
                }
            }
        }
    }
}