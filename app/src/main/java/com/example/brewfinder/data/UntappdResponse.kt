package com.example.brewfinder.data

import com.example.brewfinder.data.brewerydata.BreweryData
import com.example.brewfinder.data.brewerydata.BreweryInfoData
import com.google.gson.annotations.SerializedName

data class UntappdResponse(
    @SerializedName("response")
    val response: BreweryData
)

data class UntappdBreweryData(
    @SerializedName("response")
    val response: BreweryInfoData
)
