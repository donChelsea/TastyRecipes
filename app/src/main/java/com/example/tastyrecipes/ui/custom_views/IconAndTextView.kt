package com.example.tastyrecipes.ui.custom_views

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tastyrecipes.R

@Composable
fun IconAndTextView(
    text: String,
    icon: Int,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(painter = painterResource(id = icon), contentDescription = "Prep time")
        Text(
            text = text,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
fun TimeAndServingsView(
    prepTime: Int,
    servings: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
) {
        IconAndTextView(text = stringResource(id = R.string.prep_time_text, prepTime), icon = R.drawable.ic_timer)
        Spacer(modifier = Modifier.width(36.dp))
        IconAndTextView(text = stringResource(id = R.string.serves_text, servings), icon = R.drawable.ic_people)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewIconAndTextView() {
    TimeAndServingsView(20, 8)
}
