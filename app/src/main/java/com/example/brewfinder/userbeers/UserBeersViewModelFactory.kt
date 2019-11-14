package com.example.brewfinder.userbeers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UserBeersViewModelFactory(private val user: String) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserBeersViewModel(user) as T
    }
}