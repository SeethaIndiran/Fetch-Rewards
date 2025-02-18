package com.example.fetchapp.data

import com.example.fetchapp.models.Item
import retrofit2.http.GET

interface FetchAPIService {
    @GET("hiring.json")
    suspend fun getItems():List<Item>
}