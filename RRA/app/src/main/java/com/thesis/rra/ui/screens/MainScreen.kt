package com.thesis.rra.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.thesis.rra.domain.viewmodels.RestaurantsViewModel
import com.thesis.rra.ui.Screen
import com.thesis.rra.ui.components.RestaurantTypeCard

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreenUI(
    navController: NavController,
) {

    val viewModel = RestaurantsViewModel()
    val typesList by viewModel.typesList.observeAsState()
    val refreshing by remember { mutableStateOf(false) }

    viewModel.getRestaurantTypes()

    val pullRefreshState = rememberPullRefreshState(
        refreshing = refreshing,
        onRefresh = viewModel::getRestaurantTypes
    )

    Box (
        modifier = Modifier
            .fillMaxSize()
            .pullRefresh(pullRefreshState)
    ) {

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            item {
                Text(
                    text = "Welcome!"
                )
            }

            typesList?.let {
                items(it) {
                    RestaurantTypeCard(
                        type = it,
                        onClick = {
                            navController.navigate(Screen.RestaurantType.route + "/" + it)
                        }
                    )
                }
            }
        }

        PullRefreshIndicator(
            refreshing = refreshing,
            state = pullRefreshState,
            modifier = Modifier.align(Alignment.TopCenter),
            backgroundColor = Color.Black
        )
    }
}
