package com.thesis.rra.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thesis.rra.data.Restaurant
import org.bson.types.ObjectId

@Composable
fun RestaurantCard(res: Restaurant) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        modifier = Modifier
            .size(width = 240.dp, height = 100.dp)
    ) {
        Text(
            text = res.name,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center
        )
    }
}


@Preview
@Composable
fun RestaurantCardPreview() {
    val res = Restaurant(
        id = ObjectId(),
        name = "MyRestaurant",
        type = "Italian",
        latitude = "12.345",
        longitude = "45.678",
        reviewStars = "4.2"
    )

    RestaurantCard(res)
}