package com.example.brewfinder.data.brewerydata

import com.google.gson.annotations.SerializedName

data class BreweryItems(

    @SerializedName("items")
    val items: List<BreweryDetails>
)