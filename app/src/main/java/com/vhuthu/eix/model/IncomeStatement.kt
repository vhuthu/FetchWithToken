package com.vhuthu.eix.model

data class IncomeStatement(
    val id: Int,
    val incomeStatementItems: List<IncomeStatementItem>,
    val netIncome: Double,
    val statementDate: String,
    val totalExpenses: Double,
    val totalIncome: Double
)