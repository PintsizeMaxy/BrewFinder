package com.example.brewfinder.data.brewerydata

import com.example.brewfinder.data.beerdata.Beer
import com.example.brewfinder.data.pubdata.PubCheckinData
import com.google.gson.annotations.SerializedName

data class BreweryData(
    @SerializedName("brewery")
    val brewery: BreweryItems,
    @SerializedName("checkins")
    val checkins: PubCheckinData,
    @SerializedName("beer")
    val beer: Beer
)
