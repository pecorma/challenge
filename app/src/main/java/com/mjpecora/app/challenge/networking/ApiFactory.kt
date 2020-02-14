package com.mjpecora.app.challenge.networking

import com.mjpecora.app.challenge.utils.API_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {
    private val retrofit: Retrofit
        get() {
            return Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    val api: ChallengeApi = retrofit.create(ChallengeApi::class.java)
}