package com.vhuthu.eix.model

data class Asset(
    val age: Int,
    val assetName: String,
    val assetType: String,
    val assetValue: Double,
    val id: Int,
    val proofOfOwnership: String,
    val purchasePrice: Double
)