package com.example.brewfinder.data

import com.example.brewfinder.data.beerdata.BeerData
import com.example.brewfinder.data.brewerydata.BreweryData
import com.example.brewfinder.data.brewerydata.BreweryInfoData
import com.example.brewfinder.data.pubdata.PubCheckinData
import com.example.brewfinder.data.pubdata.PubCheckinResponse
import com.google.gson.annotations.SerializedName

data class UntappdBrewerySearchData(
    @SerializedName("response")
    val response: BreweryData
)

data class UntappdBreweryData(
    @SerializedName("response")
    val response: BreweryInfoData
)

data class UntappdBeerData(
    @SerializedName("response")
    val response: BeerData
)

data class UntappdPubData(
    @SerializedName("response")
    val response: PubCheckinResponse
)