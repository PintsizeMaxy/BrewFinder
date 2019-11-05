package com.example.brewfinder.data.brewerydata

import com.google.gson.annotations.SerializedName

data class BreweryData (
    @SerializedName("brewery")
    val brewery: BreweryItems
)
