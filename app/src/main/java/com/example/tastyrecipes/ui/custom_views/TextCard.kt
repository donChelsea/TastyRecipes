package com.example.tastyrecipes.ui.custom_views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.example.tastyrecipes.domain.models.Recipe
import com.example.tastyrecipes.domain.models.Topic
import com.example.tastyrecipes.domain.models.UserRating
import com.example.tastyrecipes.ui.theme.Purple500

@Composable
fun TextCard(
    topics: String,
    width: Dp,
) {
    Card(
        modifier = Modifier
            .width(width)
            .padding(start = 8.dp, top = 8.dp, bottom = 8.dp, end = 8.dp)
            .clickable{ },
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = topics,
                color = Purple500,
                fontSize = 13.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTextCard() {
    TextCard(
        "Chicken, Turkey",
        width = 400.dp
    )
}