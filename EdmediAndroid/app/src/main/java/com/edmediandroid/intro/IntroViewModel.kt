package com.edmediandroid.intro

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class IntroViewModel : ViewModel() {
    private val introRepository = IntroRepository()

    private val _loginResult = MutableLiveData<Result<String>>()
    val loginResult: LiveData<Result<String>> get() = _loginResult

    fun login(context: Context) {
        viewModelScope.launch {
            introRepository.login(context, _loginResult)
        }
    }
}