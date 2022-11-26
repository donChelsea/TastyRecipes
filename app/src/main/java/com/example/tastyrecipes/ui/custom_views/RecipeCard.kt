package com.example.tastyrecipes.ui.custom_views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.tastyrecipes.R
import com.example.tastyrecipes.domain.models.Recipe
import com.example.tastyrecipes.domain.models.Topic
import com.example.tastyrecipes.domain.models.UserRating
import com.example.tastyrecipes.ui.theme.White

val CARD_WIDTH = 300.dp
val CARD_HEIGHT = 200.dp
val IMAGE_HEIGHT = 500.dp

@ExperimentalComposeUiApi
@Composable
fun RecipeCard(
    recipe: Recipe
) {
    Card(
        modifier = Modifier
            .size(width = CARD_WIDTH, height = CARD_HEIGHT)
            .clickable { },
        elevation = 10.dp
    ) {
        Box {
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
                    .size(width = CARD_WIDTH, height = IMAGE_HEIGHT)
            )
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .background(brush = Brush.verticalGradient(listOf(Color.Transparent, Color.Black)))
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 12.dp, start = 12.dp, end = 12.dp)
                ) {
                    Text(
                        text = recipe.name,
                        color = White,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.width(CARD_WIDTH)
                    )
                    StarRatingView(
                        score = recipe.userRating.score,
                        textColor = Color.White,
                        modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
                    )
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