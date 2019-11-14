package com.example.brewfinder.data.beerdata

import com.google.gson.annotations.SerializedName

data class BeerBreweryItems (

    @SerializedName("items")
    val items: List<BeerBreweryData>
)