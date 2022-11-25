package com.example.tastyrecipes.ui.custom_views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import com.example.tastyrecipes.R
import com.example.tastyrecipes.ui.theme.LightPurple

@Composable
fun EmptySearchView() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            colorFilter = ColorFilter.tint(LightPurple)
        )
    }
}