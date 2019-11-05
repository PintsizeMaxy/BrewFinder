package com.example.brewfinder.data.beerdata

import com.google.gson.annotations.SerializedName

data class BeerItems (

    @SerializedName("items")
    val items: List<BeerData>
)