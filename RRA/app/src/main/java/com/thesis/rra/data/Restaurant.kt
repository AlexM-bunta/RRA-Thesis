package com.thesis.rra.data

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.codecs.pojo.annotations.BsonProperty
import org.bson.types.ObjectId

data class Restaurant(
    @BsonId
    val id: ObjectId,

    @BsonProperty("Name")
    val name: String,

    @BsonProperty("Type")
    val type: String,

    @BsonProperty("Latitude")
    val latitude: String,

    @BsonProperty("Longitude")
    val longitude: String,

    @BsonProperty("Review_Stars")
    val reviewStars: String
)
