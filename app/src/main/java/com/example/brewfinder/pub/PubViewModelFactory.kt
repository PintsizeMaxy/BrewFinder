package com.example.brewfinder.pub

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.brewfinder.MainActivity

class PubViewModelFactory(private val activity: MainActivity) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PubViewModel(activity) as T
    }
}