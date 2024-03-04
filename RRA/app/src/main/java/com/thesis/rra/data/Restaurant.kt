package com.thesis.rra.data

import com.google.gson.annotations.SerializedName

data class Restaurant(
    @SerializedName("_id")
    val id: String,

    @SerializedName("Name")
    val name: String,

    @SerializedName("Type")
    val type: String,

    @SerializedName("Latitude")
    val latitude: Double,

    @SerializedName("Longitude")
    val longitude: Double,

    @SerializedName("Review_Stars")
    val reviewStars: Double
)
