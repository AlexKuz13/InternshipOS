package com.alexkuz.exchangerates.data.network

import com.alexkuz.exchangerates.model.CurrencyResult
import com.alexkuz.exchangerates.util.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CurrenciesRestRepositoryImpl(
    private val currencyApi: CurrencyApi
) : CurrenciesRestRepository {

    override suspend fun getCurrencies(): NetworkResult<CurrencyResult> {
        return withContext(Dispatchers.IO) {
            val response = currencyApi.getCurrencies()
            response.body()?.let { result ->
                NetworkResult.Success(result)
            }
                ?: NetworkResult.Error()
        }
    }
}