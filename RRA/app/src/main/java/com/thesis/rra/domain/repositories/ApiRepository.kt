package com.thesis.rra.domain.repositories

import android.util.Log
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.thesis.rra.data.Restaurant
import com.thesis.rra.domain.http.HttpClient
import com.thesis.rra.domain.interfaces.ApiHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class ApiRepository (
    private val httpClient: Retrofit = HttpClient.retrofit
) {

    private val TAG = "REPO_CALL"

    private val api: ApiHelper =
        httpClient.create(ApiHelper::class.java)

    fun getAll(onComplete: (SnapshotStateList<Restaurant>) -> Unit) {
        var restaurantList: SnapshotStateList<Restaurant> = SnapshotStateList<Restaurant>()

        api.getAll().enqueue(object: Callback<List<Restaurant>> {
            override fun onResponse(
                call: Call<List<Restaurant>>,
                response: Response<List<Restaurant>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        for (res in it) {
                            Log.i(TAG, "onResponse: ${res.name}")
                            restaurantList.add(res)
                        }
                    }

                    onComplete(restaurantList)
                }
                else {
                    Log.i(TAG, "onResponse: not successful")
                }
            }

            override fun onFailure(call: Call<List<Restaurant>>, t: Throwable) {
                Log.i(TAG, "onFailure: ${t.message}")
            }
        })
    }

    fun getTypes(onComplete: (SnapshotStateList<String>) -> Unit) {
        var typesList: SnapshotStateList<String> = SnapshotStateList<String>()

        api.getTypes().enqueue(object: Callback<List<String>> {
            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        for (type in it) {
                            Log.i(TAG, "onResponse: ${type}")
                            typesList.add(type)
                        }
                    }

                    onComplete(typesList)
                }
                else {
                    Log.i(TAG, "onResponse: not successful")
                }
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                Log.i(TAG, "onFailure: ${t.message}")
            }

        })
    }

    fun getByType(type: String, onComplete: (SnapshotStateList<Restaurant>) -> Unit) {
        var restaurantList: SnapshotStateList<Restaurant> = SnapshotStateList<Restaurant>()

        api.getByType(type).enqueue(object: Callback<List<Restaurant>> {
            override fun onResponse(call: Call<List<Restaurant>>, response: Response<List<Restaurant>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        for (res in it) {
                            Log.i(TAG, "onResponse: ${res.name}")
                            restaurantList.add(res)
                        }
                    }

                    onComplete(restaurantList)
                }
                else {
                    Log.i(TAG, "onResponse: not successful")
                }
            }

            override fun onFailure(call: Call<List<Restaurant>>, t: Throwable) {
                Log.i(TAG, "onFailure: ${t.message}")
            }
        })
    }
}