package com.vhuthu.eix.model

data class Crop(
    val id: Int,
    val marketValue: Double,
    val name: String,
    val price: Double,
    val season: String,
    val type: String
)