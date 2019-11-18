package com.example.brewfinder.userbeers

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brewfinder.client.UntappdApi
import com.example.brewfinder.data.beerdata.BeerBreweryItems
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import timber.log.Timber

class UserBeersViewModel : ViewModel() {

    val viewState = MutableLiveData<List<UserBeersItem>>()
    var job: Job? = null

    fun findUserBeers(user: String) {
        job?.cancel()

        job = viewModelScope.launch {
            try {
                val apiResult = viewModelScope.async {
                    UntappdApi.retrofit.userBeers(user)
                }
                viewState.postValue(apiResult.await().response.beers.items.map { UserBeersItem(it) })
            }catch (t: Throwable){
                Timber.e(t)
            }
        }
    }
}