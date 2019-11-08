package com.example.brewfinder.breweries

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brewfinder.BuildConfig
import com.example.brewfinder.client.UntappdApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import timber.log.Timber

class BreweryViewModel : ViewModel() {

    val viewState = MutableLiveData<List<BreweryItem>>()
    var job: Job? = null

    fun searchBreweries(search: String) {
        job?.cancel()

        job = viewModelScope.launch {
            try {
                val apiResult = viewModelScope.async {
                    UntappdApi.retrofit.searchBrewery(
                        search,
                        BuildConfig.API_ID,
                        BuildConfig.API_SECRET
                    )
                }
                viewState.postValue(apiResult.await().response.brewery.items.map { BreweryItem(it.brewery) })
            }catch (t: Throwable){
                Timber.e(t)
            }
        }
    }
}