package com.thesis.rra.domain.database

import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoDatabase

object MongoDBConnection {
    private const val CONNECTION_STRING = "mongodb://localhost:27017"
    private const val DATABASE_NAME = "RRApp"

    fun getDatabase(): MongoDatabase {
        val client = MongoClient.create(connectionString = CONNECTION_STRING)
        return client.getDatabase(databaseName = DATABASE_NAME)
    }
}