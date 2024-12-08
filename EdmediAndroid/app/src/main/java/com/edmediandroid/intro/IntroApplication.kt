package com.edmediandroid.intro

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import com.edmediandroid.BuildConfig
import com.kakao.sdk.common.KakaoSdk

class IntroApplication : Application() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate() {
        super.onCreate()

        KakaoSdk.init(applicationContext, getKakaoAppKey())
    }

    private fun getKakaoAppKey() : String = BuildConfig.kakaoAppKey
}