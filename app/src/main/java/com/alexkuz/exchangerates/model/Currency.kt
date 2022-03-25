package com.alexkuz.exchangerates.model

data class Currency(
    val symbols: String,
    val exchange_rate: Int,
    val title: String
)

fun getCurrencies(): List<Currency> {
    return listOf(
        Currency(symbols = "EUR", 100, "Евро"),
        Currency(symbols = "USD", 90, "Доллар"),
        Currency(symbols = "AMD", 80, "Амд"),
        Currency(symbols = "UAN", 110, "Юань"),
        Currency(symbols = "EUR", 100, "Евро"),
        Currency(symbols = "USD", 90, "Доллар"),
        Currency(symbols = "AMD", 80, "Амд"),
        Currency(symbols = "UAN", 110, "Юань"),
        Currency(symbols = "EUR", 100, "Евро"),
        Currency(symbols = "USD", 90, "Доллар"),
        Currency(symbols = "AMD", 80, "Амд"),
        Currency(symbols = "UAN", 110, "Юань"),
        Currency(symbols = "EUR", 100, "Евро"),
        Currency(symbols = "USD", 90, "Доллар"),
        Currency(symbols = "AMD", 80, "Амд"),
        Currency(symbols = "UAN", 110, "Юань"),
        Currency(symbols = "EUR", 100, "Евро"),
        Currency(symbols = "USD", 90, "Доллар"),
        Currency(symbols = "AMD", 80, "Амд"),
        Currency(symbols = "UAN", 110, "Юань"),
        Currency(symbols = "EUR", 100, "Евро"),
        Currency(symbols = "USD", 90, "Доллар"),
        Currency(symbols = "AMD", 80, "Амд"),
        Currency(symbols = "UAN", 110, "Юань")
    )
}