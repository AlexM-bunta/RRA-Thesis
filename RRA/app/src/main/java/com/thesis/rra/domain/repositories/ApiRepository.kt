package com.thesis.rra.domain.repositories

import com.thesis.rra.data.Restaurant
import com.thesis.rra.domain.http.HttpClient
import com.thesis.rra.domain.interfaces.ApiHelperImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit

class RestaurantRepository (
    private val httpClient: Retrofit = HttpClient.retrofit
): ApiHelperImpl {

    private val repository: ApiHelperImpl =
        httpClient.create(ApiHelperImpl::class.java)

    override suspend fun getAll(): Flow<List<Restaurant>> = flow {
        emit(repository.getAll())
    }
}