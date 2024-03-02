package com.thesis.rra.domain.interfaces

import com.thesis.rra.data.Restaurant
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ApiHelperImpl {
    @GET("/restaurants/getAll")
    suspend fun getAll(): Flow<List<Restaurant>>
}