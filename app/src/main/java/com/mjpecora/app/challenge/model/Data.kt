package com.mjpecora.app.challenge.model

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
)