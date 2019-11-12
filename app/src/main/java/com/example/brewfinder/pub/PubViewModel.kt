package com.example.brewfinder.pub

import android.location.Location
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brewfinder.BuildConfig
import com.example.brewfinder.MainActivity
import com.example.brewfinder.client.UntappdApi
import com.example.brewfinder.data.pubdata.PubCheckinData
import com.example.brewfinder.data.pubdata.PubItemsData
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import timber.log.Timber

class PubViewModel(private val activity: MainActivity) : ViewModel() {

    val viewState = MutableLiveData<List<PubItemView>>()
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    var job: Job? = null

    init {
        loadNearby()
    }

    private fun loadNearby() {
        job?.cancel()

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(activity)
        fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
            location?.let {
                job = viewModelScope.launch {
                    try {
                        val apiResult = viewModelScope.async {
                            UntappdApi.retrofit.thePub(
                                BuildConfig.API_ID,
                                BuildConfig.API_SECRET,
                                it.latitude.toFloat(),
                                it.longitude.toFloat()
                            )
                        }
                        viewState.postValue(apiResult.await().response.checkins.items.map {
                            PubItemView(it)
                        })
                    } catch (t: Throwable) {
                        Timber.e(t)
                    }
                }
            }
        }
    }
}