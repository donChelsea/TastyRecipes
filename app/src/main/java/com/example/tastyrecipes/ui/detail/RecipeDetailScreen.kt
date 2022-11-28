package com.example.tastyrecipes.ui.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.tastyrecipes.R
import com.example.tastyrecipes.ui.custom_views.*

@Composable
fun RecipeDetailScreen(
    navController: NavHostController,
    recipeId: Int
) {
    val viewModel = hiltViewModel<DetailViewModel>()

    LaunchedEffect(key1 = recipeId) {
        viewModel.getRecipeDetails(recipeId)
    }

    val uiState = viewModel.uiState.collectAsState()
    val recipe = uiState.value.data

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(recipe?.thumbnail)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_placeholder),
                contentDescription = recipe?.thumbnailAltText,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .graphicsLayer { alpha = 0.99f }
                    .drawWithContent {
                        val colors = listOf(
                            Color.Black,
                            Color.Transparent
                        )
                        drawContent()
                        drawRect(
                            brush = Brush.verticalGradient(colors),
                            blendMode = BlendMode.DstIn
                        )
                    }
                    .clip(RectangleShape)
                    .height(250.dp)
            )
            Box(
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(recipe?.thumbnail)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_placeholder),
                    contentDescription = recipe?.thumbnailAltText,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(width = 200.dp, height = 200.dp)
                )
            }
        }
        Text(
            text = recipe?.name.toString(),
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(16.dp)
        )
        recipe?.nutrition?.let {
            NutritionView(nutrition = it)
        }

        recipe?.sections?.let { IngredientsView(it) }

    }
}
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewRecipeDetailScreen() {
//    RecipeDetailScreen(navController = rememberNavController(), recipeId = mockRecipe.id)
//}