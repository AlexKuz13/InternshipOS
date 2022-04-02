package com.alexkuz.exchangerates.domain

import com.alexkuz.exchangerates.model.CurrencyResult

interface CurrenciesRepository {

    suspend fun getCurrencies(): CurrencyResult

}