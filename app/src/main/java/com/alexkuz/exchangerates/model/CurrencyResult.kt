package com.alexkuz.exchangerates.model


import com.google.gson.annotations.SerializedName

data class CurrencyResult(
    @SerializedName("Valute")
    val currency: Map<String, Currency>
)