package com.example.brewfinder.brewerysearch

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brewfinder.client.UntappdApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import timber.log.Timber

class BrewerySearchViewModel : ViewModel() {

    val viewState = MutableLiveData<List<BrewerySearchItem>>()
    var job: Job? = null

    fun searchBreweries(search: String) {
        job?.cancel()

        job = viewModelScope.launch {
            try {
                val apiResult = viewModelScope.async {
                    UntappdApi.retrofit.searchBrewery(search)
                }
                viewState.postValue(apiResult.await().response.brewery.items.map { BrewerySearchItem(it.brewery) })
            }catch (t: Throwable){
                Timber.e(t)
            }
        }
    }
}