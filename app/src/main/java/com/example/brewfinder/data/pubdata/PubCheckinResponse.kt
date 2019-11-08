package com.example.brewfinder.data.pubdata

import com.google.gson.annotations.SerializedName

data class PubCheckinResponse(
    @SerializedName("checkins")
    val checkins: PubCheckinData
)