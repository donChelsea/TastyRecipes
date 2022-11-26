package com.example.tastyrecipes.ui.custom_views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tastyrecipes.R
import com.example.tastyrecipes.ui.theme.StarYellow
import com.example.tastyrecipes.utils.getStarRating

@ExperimentalComposeUiApi
@Composable
fun StarRatingView(
    score: Double
) {
    val stars = getStarRating(score)
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(painter = painterResource(
            id = R.drawable.ic_star_rate),
            contentDescription = "",
            tint = StarYellow
        )
        Text(
            text = pluralStringResource(id = R.plurals.numberOfStarsRating, stars, stars)
        )
    }
}


@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun PreviewStarRatingView() {
    StarRatingView(0.8881424253)
}