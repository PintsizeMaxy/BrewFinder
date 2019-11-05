package com.example.brewfinder.breweries

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brewfinder.BuildConfig
import com.example.brewfinder.client.UntappdApi
import com.example.brewfinder.data.UntappdBrewerySearchData
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import timber.log.Timber

class BreweryViewModel : ViewModel() {

    val viewState = MutableLiveData<UntappdBrewerySearchData>()
    var job: Job? = null

    fun searchBreweries(search: String) {
        job?.cancel()

        job = viewModelScope.launch {
            try {
                val apiResult = viewModelScope.async {
                    UntappdApi.service.searchBrewery(
                        search,
                        BuildConfig.API_ID,
                        BuildConfig.API_SECRET
                    )
                }
                viewState.postValue(apiResult.await())
            }catch (t: Throwable){
                Timber.e(t)
            }
        }
    }
}