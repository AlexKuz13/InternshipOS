package com.alexkuz.exchangerates.domain

import com.alexkuz.exchangerates.model.CurrencyResult
import com.alexkuz.exchangerates.util.NetworkResult

interface CurrenciesRepository {

    suspend fun getCurrencies(): NetworkResult<CurrencyResult>

}