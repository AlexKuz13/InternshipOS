package com.alexkuz.exchangerates.data.network

import android.content.Context
import com.alexkuz.exchangerates.R
import com.alexkuz.exchangerates.model.CurrencyResult
import com.alexkuz.exchangerates.util.NetworkResult

class CurrenciesRestRepositoryImpl(
    private val currencyApi: CurrencyApi,
    private val context: Context
) : CurrenciesRestRepository {

    override suspend fun getCurrencies(): NetworkResult<CurrencyResult> {
        val response = currencyApi.getCurrencies()
        return when {
            response.message().toString().contains(context.getString(R.string.timeout_error)) ->
                NetworkResult.Error(context.getString(R.string.timeout_error))
            response.code() == 500 ->
                NetworkResult.Error(context.getString(R.string.error_500))
            response.code() == 404 ->
                NetworkResult.Error(context.getString(R.string.error_404))
            response.body()?.currency.isNullOrEmpty() ->
                NetworkResult.Error(context.getString(R.string.exchange_rates_not_found))
            response.isSuccessful -> {
                val result = response.body()!!
                NetworkResult.Success(result)
            }
            else ->
                NetworkResult.Error(response.message())
        }
    }
}