package com.alexkuz.exchangerates.data.network

import com.alexkuz.exchangerates.model.CurrencyResult
import com.alexkuz.exchangerates.util.NetworkResult

interface CurrenciesRestRepository {

    suspend fun getCurrencies(): NetworkResult<CurrencyResult>
}