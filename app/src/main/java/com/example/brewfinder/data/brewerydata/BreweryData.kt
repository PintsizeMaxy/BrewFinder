package com.example.brewfinder.data.brewerydata

import com.example.brewfinder.data.beerdata.Beer
import com.example.brewfinder.data.beerdata.BeerBreweryItems
import com.example.brewfinder.data.pubdata.PubCheckinData
import com.google.gson.annotations.SerializedName

data class BreweryData(
    @SerializedName("total_count")
    val totalCount: Int,
    @SerializedName("brewery")
    val brewery: BeerBreweryItems,
    @SerializedName("checkins")
    val checkins: PubCheckinData,
    @SerializedName("beer")
    val beer: Beer,
    @SerializedName("beers")
    val beers: BeerBreweryItems
)
