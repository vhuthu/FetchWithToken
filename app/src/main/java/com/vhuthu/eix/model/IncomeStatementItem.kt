package com.vhuthu.eix.model

data class IncomeStatementItem(
    val amount: Double,
    val category: String,
    val date: String,
    val description: String,
    val id: Int,
    val proofOfReceipt: String
)