package com.example.brewfinder.data.beerdata

import com.example.brewfinder.data.pubdata.PubCheckinData
import com.google.gson.annotations.SerializedName

data class Beer (

    @SerializedName("bid")
    val bid: Int,
    @SerializedName("beer_name")
    val beerName: String,
    @SerializedName("beer_label")
    val beerLabel: String,
    @SerializedName("beer_style")
    val beerStyle: String,
    @SerializedName("beer_abv")
    val beerAbv: Double,
    @SerializedName("beer_ibu")
    val beerIbu: Int = 0,
    @SerializedName("beer_description")
    val description: String = "",
    @SerializedName("rating_score")
    val ratingScore: Float = 0F,
    @SerializedName("checkins")
    val checkins: PubCheckinData

)