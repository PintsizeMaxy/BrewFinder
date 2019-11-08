package com.example.brewfinder.data.pubdata

import com.google.gson.annotations.SerializedName

data class UntappdUser(
    @SerializedName("user_name")
    val userName: String,
    @SerializedName("user_avatar")
    val userAvatar: String
)