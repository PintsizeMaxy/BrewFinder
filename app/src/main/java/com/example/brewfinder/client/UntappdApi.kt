package com.example.brewfinder.client

import com.example.brewfinder.BuildConfig
import com.example.brewfinder.data.UntappdBreweryData
import com.example.brewfinder.data.UntappdResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UntappdApi {
    @GET("brewery/info/{brewery}")
    suspend fun getBrewery(
        @Path("brewery") brewery: Int,
        @Query("client_id") client_id: String = BuildConfig.API_ID,
        @Query("client_secret") client_secret: String = BuildConfig.API_SECRET
    ): UntappdBreweryData

    @GET("search/brewery")
    suspend fun searchBrewery(
        @Query("q") q: String,
        @Query("client_id") client_id: String = BuildConfig.API_ID,
        @Query("client_secret") client_secret: String = BuildConfig.API_SECRET
    ): UntappdResponse

    @GET("beer/info/{BID}")
    suspend fun getBeer(
        @Path("BID") BID: Int,
        @Query("client_id") client_id: String = BuildConfig.API_ID,
        @Query("client_secret") client_secret: String = BuildConfig.API_SECRET,
        @Query("compact") compact: Boolean = true
    ): UntappdResponse

    @GET("thepub/local")
    suspend fun thePub(
        @Query("client_id") client_id: String = BuildConfig.API_ID,
        @Query("client_secret") client_secret: String = BuildConfig.API_SECRET,
        @Query("lat") lat: Float,
        @Query("lng") lng: Float,
        @Query("radius") radius: Int = 15,
        @Query("dist_pref") dist_pref: String = "m"
    ) : UntappdResponse

    @GET("/v4/user/beers/{USERNAME}")
    suspend fun userBeers(
        @Path("USERNAME") USERNAME: String,
        @Query("client_id") client_id: String = BuildConfig.API_ID,
        @Query("client_secret") client_secret: String = BuildConfig.API_SECRET
    ) : UntappdResponse

    companion object {
        val retrofit = Retrofit.Builder().baseUrl("https://api.untappd.com/v4/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(UntappdApi::class.java)
    }
}