package com.sunasterisk.a14day_challenge.data.model

data class User(
    val account: String,
    var name: String,
    var password: String,
    val birthday: String,
    var height: Double,
    var weight: Double,
    var process: Int
)
