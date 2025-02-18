package com.example.fetchapp.data

import com.example.fetchapp.models.Item

interface FetchRepository {

    suspend fun getItems():List<Item>
}