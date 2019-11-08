package com.example.brewfinder.data.pubdata

import com.google.gson.annotations.SerializedName

data class VenueData(
    @SerializedName("venue_name")
    val venueName: String
)