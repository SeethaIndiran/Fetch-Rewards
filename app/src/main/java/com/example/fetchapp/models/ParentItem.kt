package com.example.fetchapp.models

import com.google.gson.annotations.SerializedName

data class ParentItem (
    @SerializedName("listId") val listId:Int ,
    @SerializedName("itemsList") val itemsList :List<Item>,
    @SerializedName("isExpandable") var isExpandable:Boolean
)