package com.example.tastyrecipes.ui.custom_views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tastyrecipes.data.dtos.mappers.toMap
import com.example.tastyrecipes.domain.models.Nutrition
import com.example.tastyrecipes.ui.widgets.Carousel
import com.example.tastyrecipes.ui.widgets.SectionContainerSmallHeader

@Composable
fun NutritionView(
    nutrition: Nutrition
) {
    Column {
        val items = nutrition.toMap()

        SectionContainerSmallHeader(title = "Nutrition") {
            Carousel(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(8.dp)
            ) {
                items(items) { item ->
                    NutritionCard(title = item.first, nutritionValue = item.second)
                }
            }
        }
    }
}

@Composable
fun NutritionCard(
    title: String,
    nutritionValue: Int
) {
    Card(
        modifier = Modifier
            .width(width = 160.dp)
            .padding(8.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier.padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.SemiBold
            )
            Text(text = nutritionValue.toString())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNutritionCard() {
    NutritionCard("Fat", 120)
}
@Preview(showBackground = true)
@Composable
fun PreviewNutritionCard2() {
    NutritionCard("Carbohydrates", 130)
}