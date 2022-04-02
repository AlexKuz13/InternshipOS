package com.alexkuz.exchangerates.model


import com.google.gson.annotations.SerializedName

data class CurrencyResponse(
    @SerializedName("Valute")
    val currency: Map<String, Currency>
)