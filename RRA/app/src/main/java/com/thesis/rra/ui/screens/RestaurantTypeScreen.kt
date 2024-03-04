package com.thesis.rra.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.thesis.rra.domain.viewmodels.RestaurantsViewModel
import com.thesis.rra.ui.components.RestaurantCard

@Composable
fun RestaurantTypeUI(
    navController: NavController,
    type: String
) {
    val viewModel = RestaurantsViewModel()
    val restaurantList by viewModel.restaurantsList.observeAsState()

    viewModel.getByType(type)

    Box (
        modifier = Modifier
            .fillMaxSize()
    ) {

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            restaurantList?.let {
                items(it) {
                    RestaurantCard(
                        res = it
                    ) {
                        viewModel.openGoogleMaps(latitude = it.latitude, longitude = it.longitude)
                    }
                }
            }
        }
    }
}