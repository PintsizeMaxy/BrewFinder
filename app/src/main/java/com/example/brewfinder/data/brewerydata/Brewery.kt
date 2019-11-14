package com.example.brewfinder.data.brewerydata

import com.example.brewfinder.data.beerdata.BeerBreweryItems
import com.google.gson.annotations.SerializedName

data class Brewery (
    @SerializedName("brewery_id")
    val breweryId: Int,
    @SerializedName("brewery_name")
    val breweryName: String,
    @SerializedName("brewery_label")
    val breweryLabel: String,
    @SerializedName("beer_count")
    val beerCount: Int = 0,
    @SerializedName("brewery_type")
    val breweryType: String = "",
    @SerializedName("brewery_description")
    val breweryDescription: String = "",
    @SerializedName("location")
    val location: BreweryLocation,
    @SerializedName("beer_list")
    val beerList: BeerBreweryItems = BeerBreweryItems(emptyList())
    )