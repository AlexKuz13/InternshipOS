package com.alexkuz.exchangerates.data.network

import com.alexkuz.exchangerates.model.CurrencyResponse

class CurrenciesRestRepositoryImpl(
    private val currencyApi: CurrencyApi
) : CurrenciesRestRepository {

    override suspend fun getCurrencies(): CurrencyResponse {
        return currencyApi.getCurrencies().body()!!
    }
}