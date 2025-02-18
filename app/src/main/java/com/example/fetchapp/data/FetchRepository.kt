package com.example.fetchapp.data

import com.example.fetchapp.models.Item
import javax.inject.Inject


class FetchRepository @Inject constructor(private val apiService: FetchAPIService){

    suspend fun fetchItems():List<Item>{
        return apiService.getItems()
          //  .filter { it.name.isNotBlank() }
          //  .sortedWith(compareBy({ it.listId }, { it.name }))
    }
}