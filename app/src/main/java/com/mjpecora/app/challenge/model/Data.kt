package com.mjpecora.app.challenge.model

import android.view.View

data class Base(
    val data: List<Data>
)

data class Data(
    val startDate: String,
    val endDate: String,
    val name: String,
    val url: String,
    val venue: Venue,
    val icon: String
) {
    var listener: View.OnClickListener? = null
}