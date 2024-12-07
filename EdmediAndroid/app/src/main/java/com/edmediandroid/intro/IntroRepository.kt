package com.edmediandroid.intro

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class IntroRepository {

    suspend fun login(): Result<String> {
        return withContext(Dispatchers.IO) {
            Result.failure(Exception("Kakao Login Fail"))
        }
    }
}