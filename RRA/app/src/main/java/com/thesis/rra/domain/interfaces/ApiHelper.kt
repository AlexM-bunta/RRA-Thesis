package com.thesis.rra.domain.interfaces

import com.thesis.rra.data.Restaurant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiHelper {
    @GET("restaurants/getAll")
    fun getAll(): Call<List<Restaurant>>

    @GET("restaurants/getTypes")
    fun getTypes(): Call<List<String>>

    @GET("restaurants/get/{type}")
    fun getByType(@Path("type") type: String): Call<List<Restaurant>>
}