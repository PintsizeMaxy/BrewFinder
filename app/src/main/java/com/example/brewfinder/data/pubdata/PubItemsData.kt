package com.example.brewfinder.data.pubdata

import com.example.brewfinder.data.beerdata.Beer
import com.example.brewfinder.data.brewerydata.Brewery
import com.google.gson.annotations.SerializedName

data class PubItemsData(
    @SerializedName("rating_score")
    val ratingScore: Float,
    @SerializedName("checkin_comment")
    val checkinComment: String,
    @SerializedName("user")
    val user: UntappdUser,
    @SerializedName("beer")
    val beer: Beer,
    @SerializedName("brewery")
    val brewery: Brewery,
    @SerializedName("venue")
    val venue: VenueData
)