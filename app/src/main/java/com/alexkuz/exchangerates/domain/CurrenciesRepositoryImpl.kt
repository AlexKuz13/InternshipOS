package com.alexkuz.exchangerates.domain

import com.alexkuz.exchangerates.data.network.CurrenciesRestRepository
import com.alexkuz.exchangerates.model.CurrencyResponse

class CurrenciesRepositoryImpl(
    private val restRepository: CurrenciesRestRepository
) : CurrenciesRepository {

    override suspend fun getCurrencies(): CurrencyResponse {
        return restRepository.getCurrencies()
    }
}