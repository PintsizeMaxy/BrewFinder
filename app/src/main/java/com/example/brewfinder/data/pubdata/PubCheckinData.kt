package com.example.brewfinder.data.pubdata

import com.google.gson.annotations.SerializedName

data class PubCheckinData(
    @SerializedName("items")
    val items: List<PubItemsData>
)