package com.example.brewfinder.data.beerdata

import com.example.brewfinder.data.brewerydata.Brewery
import com.google.gson.annotations.SerializedName

data class BeerBreweryData (

    @SerializedName("rating_score")
    val ratingScore: Float = 0F,
    @SerializedName("beer")
    val beer: Beer,
    @SerializedName("brewery")
    val brewery: Brewery
)