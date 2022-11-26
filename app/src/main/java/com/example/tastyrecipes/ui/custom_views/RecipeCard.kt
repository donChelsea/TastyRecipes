package com.example.tastyrecipes.ui.custom_views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.tastyrecipes.R
import com.example.tastyrecipes.domain.models.Recipe
import com.example.tastyrecipes.domain.models.Topic
import com.example.tastyrecipes.domain.models.UserRating

val IMAGE_WIDTH = 310.dp
val IMAGE_HEIGHT = 200.dp
val CARD_HEIGHT = 420.dp

@ExperimentalComposeUiApi
@Composable
fun RecipeCard(
    recipe: Recipe
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(CARD_HEIGHT)
            .clickable { },
        elevation = 10.dp
    ) {
        Column {
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
                    .size(width = IMAGE_WIDTH, height = IMAGE_HEIGHT)
            )
            Column(
                modifier = Modifier
                    .padding(top = 12.dp, start = 12.dp, end = 12.dp)
            ) {
                Text(
                    text = recipe.name,
                )
                TimeAndServingsView(
                    prepTime = recipe.prepTimeMinutes,
                    servings = recipe.servings,
                )
                StarRatingView(score = recipe.userRating.score)
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                var topicsString = recipe.topics.map { it.name }.joinToString(", ")
                TextCard(topics = topicsString, IMAGE_WIDTH)
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Button(
                    onClick = {},
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 10.dp,
                        pressedElevation = 15.dp,
                        disabledElevation = 0.dp
                    ),
                ) {
                    Text(text = stringResource(id = R.string.lets_go))
                }
            }
        }
    }
}

@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun PreviewRecipeCard() {
    RecipeCard(
        recipe = Recipe(
            "Original Orange Chicken by Panda Express ",
            3383,
            20,
            UserRating(
                0.8881424253
            ),
            "",
            "",
            "",
            8,
            listOf(Topic("chicken"))
        )
    )
}