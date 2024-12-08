package com.edmediandroid.intro

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient

class IntroRepository() {

    suspend fun login(context: Context, result: MutableLiveData<Result<String>>) {
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (token != null) {
                result.postValue(Result.success(token.accessToken))
            } else {
                result.postValue(Result.failure(Exception(error?.message)))
            }
        }
        val isKakaoTalkAvailable = UserApiClient.instance.isKakaoTalkLoginAvailable(context)

        if (isKakaoTalkAvailable) {
            UserApiClient.instance.loginWithKakaoTalk(context, callback = callback)
        } else {
            UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
        }
    }
}