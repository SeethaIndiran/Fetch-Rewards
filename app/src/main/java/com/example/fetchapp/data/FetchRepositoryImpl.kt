package com.example.fetchapp.data

import com.example.fetchapp.models.Item
import javax.inject.Inject


class FetchRepositoryImpl @Inject constructor(private val apiService: FetchAPIService):FetchRepository{
    override suspend fun getItems(): List<Item> {
        return apiService.getItems()
    }


}