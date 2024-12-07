package com.edmediandroid.intro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class IntroViewModel(private val introRepository: IntroRepository) : ViewModel() {

    private val _loginResult = MutableLiveData<Result<String>>()
    val loginResult: LiveData<Result<String>> get() = _loginResult

    fun login() {
        viewModelScope.launch {
            val result = introRepository.login()
            _loginResult.postValue(result)
        }
    }
}