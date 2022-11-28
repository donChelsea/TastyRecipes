package com.example.tastyrecipes.ui.custom_views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tastyrecipes.domain.models.Ingredient
import com.example.tastyrecipes.domain.models.Section
import com.example.tastyrecipes.ui.widgets.SectionContainerSmallHeader
import com.example.tastyrecipes.utils.mockSection

@Composable
fun IngredientsView(
    sections: List<Section>
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        SectionContainerSmallHeader(title = "Ingredients") {
            IngredientsCard(sections.flatMap { it.ingredients })
        }
    }
}

@Composable
fun IngredientsCard(
    ingredients: List<Ingredient>
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            ingredients.forEach {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = false,
                        onCheckedChange = {},
                        enabled = true,
                    )
                    Text(
                        text = it.text,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewIngredientsCard() {
    IngredientsCard(ingredients = mockSection.ingredients)
}