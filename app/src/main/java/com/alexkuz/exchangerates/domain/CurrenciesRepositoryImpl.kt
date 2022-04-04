package com.alexkuz.exchangerates.domain

import android.content.Context
import com.alexkuz.exchangerates.data.network.CurrenciesRestRepository
import com.alexkuz.exchangerates.model.CurrencyResult
import com.alexkuz.exchangerates.util.NetworkResult
import com.alexkuz.exchangerates.util.hasInternetConnection

class CurrenciesRepositoryImpl(
    private val restRepository: CurrenciesRestRepository,
    private val context: Context
) : CurrenciesRepository {

    override suspend fun getCurrencies(): NetworkResult<CurrencyResult> {
        return if (hasInternetConnection(context))
            restRepository.getCurrencies()
        else NetworkResult.Error()
    }
}