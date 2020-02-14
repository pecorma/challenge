package com.mjpecora.app.challenge.networking

import com.mjpecora.app.challenge.model.Base
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ChallengeApi {
    @Headers("Content-Type: application/json")
    @GET("upcomingGuides/")
    fun getGuides(): Call<Base>
}