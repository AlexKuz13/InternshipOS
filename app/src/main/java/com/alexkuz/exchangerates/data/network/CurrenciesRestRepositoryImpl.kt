package com.alexkuz.exchangerates.data.network

import com.alexkuz.exchangerates.model.CurrencyResult

class CurrenciesRestRepositoryImpl(
    private val currencyApi: CurrencyApi
) : CurrenciesRestRepository {

    override suspend fun getCurrencies(): CurrencyResult {
        return currencyApi.getCurrencies().body()!!
    }
}