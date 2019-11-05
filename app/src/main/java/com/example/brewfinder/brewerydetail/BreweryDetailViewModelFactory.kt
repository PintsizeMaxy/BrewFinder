package com.example.brewfinder.brewerydetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BreweryDetailViewModelFactory(private val id: Int) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BreweryDetailViewModel(id) as T
    }
}