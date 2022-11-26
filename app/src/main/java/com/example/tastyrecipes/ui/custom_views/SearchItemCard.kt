package com.example.tastyrecipes.ui.custom_views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.tastyrecipes.R
import com.example.tastyrecipes.domain.models.Recipe
import com.example.tastyrecipes.utils.mockRecipe

@Composable
fun SearchItemCard(
    recipe: Recipe,
    onClick: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .size(width = 200.dp, height = 220.dp)
            .padding(12.dp)
            .clickable { onClick(recipe.id) }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(recipe.thumbnail)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_placeholder),
                contentDescription = recipe.thumbnailAltText,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RectangleShape)
                    .fillMaxWidth()
                    .height(height = 150.dp)
            )
            Text(
                text = recipe.name,
                color = Color.Black,
                modifier = Modifier
                    .padding(top = 4.dp, start = 4.dp, end = 4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchItemCard() {
    SearchItemCard(
        mockRecipe,
        onClick = {}
    )
}