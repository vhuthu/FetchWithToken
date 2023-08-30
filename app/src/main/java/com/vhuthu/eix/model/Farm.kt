package com.vhuthu.eix.model

data class Farm(
    val address: String,
    val assets: List<Asset>,
    val crops: List<Crop>,
    val farmAddress: String,
    val farmName: String,
    val farmingReason: String,
    val id: Int,
    val incomeStatements: List<IncomeStatement>,
    val numberOfEmployees: Int,
    val plots: List<Plot>,
    val yearsActive: Int
)