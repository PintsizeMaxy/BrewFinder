package com.example.brewfinder.data.beerdata

import com.example.brewfinder.data.brewerydata.Brewery
import com.google.gson.annotations.SerializedName

data class BeerBreweryData (

    @SerializedName("beer")
    val beer: Beer,
    @SerializedName("brewery")
    val brewery: Brewery
)