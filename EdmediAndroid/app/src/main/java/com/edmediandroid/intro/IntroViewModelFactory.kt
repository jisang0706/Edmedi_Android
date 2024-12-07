package com.edmediandroid.intro

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class IntroViewModelFactory(private val repository: IntroRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(IntroViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return IntroViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}