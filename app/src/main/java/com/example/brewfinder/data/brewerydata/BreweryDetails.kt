package com.example.brewfinder.data.brewerydata

import com.google.gson.annotations.SerializedName

data class BreweryDetails (
    @SerializedName("brewery")
    val brewery: Brewery
)

data class BreweryInfoData (
    @SerializedName("brewery")
    val brewery: Brewery
)