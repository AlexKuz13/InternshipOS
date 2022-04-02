package com.alexkuz.exchangerates.data.network

import com.alexkuz.exchangerates.model.CurrencyResponse
import retrofit2.Response
import retrofit2.http.GET

interface CurrencyApi {

    @GET("daily_json.js")
    suspend fun getCurrencies(): Response<CurrencyResponse>
}