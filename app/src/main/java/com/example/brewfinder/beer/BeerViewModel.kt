package com.example.brewfinder.beer

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brewfinder.BuildConfig
import com.example.brewfinder.client.UntappdApi
import com.example.brewfinder.data.beerdata.Beer
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import timber.log.Timber

class BeerViewModel(bid: Int) : ViewModel() {

    val viewScope = MutableLiveData<Beer>()
    private var job: Job? = null

    init { findBeerDetails(bid) }

    private fun findBeerDetails(id: Int) {
        job?.cancel()

        job = viewModelScope.launch {
            try {
                val apiResult = viewModelScope.async {
                    UntappdApi.retrofit.getBeer(id, BuildConfig.API_ID, BuildConfig.API_SECRET)
                }
                viewScope.postValue(apiResult.await().response.beer)
            } catch (t: Throwable) {
                Timber.e(t)
            }
        }
    }
}