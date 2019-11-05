package com.example.brewfinder.data.beerdata

import com.google.gson.annotations.SerializedName

data class BeerData (

    @SerializedName("beer")
    val beer: Beer
)