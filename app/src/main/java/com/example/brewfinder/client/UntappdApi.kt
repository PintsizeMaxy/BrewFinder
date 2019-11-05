package com.example.brewfinder.client

import com.example.brewfinder.data.UntappdBeerData
import com.example.brewfinder.data.UntappdBreweryData
import com.example.brewfinder.data.UntappdBrewerySearchData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UntappdApi {
    @GET("brewery/info/{brewery}")
    suspend fun getBrewery(
        @Path("brewery") brewery: Int = 1149,
        @Query("client_id") client_id: String,
        @Query("client_secret") client_secret: String
    ): UntappdBreweryData

    @GET("search/brewery")
    suspend fun searchBrewery(
        @Query("q") q: String,
        @Query("client_id") client_id: String,
        @Query("client_secret") client_secret: String
    ): UntappdBrewerySearchData

    @GET("beer/info/{BID}")
    suspend fun getBeer(
        @Path("BID") BID: Int,
        @Query("client_id") client_id: String,
        @Query("client_secret") client_secret: String,
        @Query("compact") compact: Boolean = true
    ): UntappdBeerData

    companion object {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://api.untappd.com/v4/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val service: UntappdApi = retrofit.create<UntappdApi>(UntappdApi::class.java)
    }
}