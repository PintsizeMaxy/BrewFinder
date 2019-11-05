package com.example.brewfinder.brewerydetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brewfinder.BuildConfig
import com.example.brewfinder.client.UntappdApi
import com.example.brewfinder.data.UntappdBreweryData
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import timber.log.Timber

class BreweryDetailViewModel(brewery: Int) : ViewModel() {

    val viewState = MutableLiveData<UntappdBreweryData>()
    var job: Job? = null

    init { fetchBreweryDetails(brewery) }

    private fun fetchBreweryDetails(id: Int) {
        job?.cancel()

        job = viewModelScope.launch {
            try {
                val apiResult = viewModelScope.async {
                    UntappdApi.service.getBrewery(
                        id,
                        BuildConfig.API_ID,
                        BuildConfig.API_SECRET)
                }
                viewState.postValue(apiResult.await())
            } catch (t: Throwable) {
                Timber.e(t)
            }
        }
    }
}