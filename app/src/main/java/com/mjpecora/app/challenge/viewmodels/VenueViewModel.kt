package com.mjpecora.app.challenge.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mjpecora.app.challenge.model.Base
import retrofit2.Callback
import com.mjpecora.app.challenge.networking.ChallengeApi
import retrofit2.Call
import retrofit2.Response

class VenueViewModel(private val api: ChallengeApi) : ViewModel() {

    val list: MutableLiveData<Base> = MutableLiveData()

    fun getList() {
        api.getGuides().enqueue(object : Callback<Base> {
            override fun onFailure(call: Call<Base>, t: Throwable) {
                Throwable(t)
            }

            override fun onResponse(call: Call<Base>, response: Response<Base>) {
                if (response.isSuccessful) {
                     list.postValue(response.body())
                }
            }
        })
    }

}