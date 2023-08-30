package com.vhuthu.eix.model

data class Data(
    val cellNumber: String,
    val email: String,
    val farms: List<Farm>,
    val firstName: String,
    val id: Int,
    val idNumber: String,
    val lastName: String
)