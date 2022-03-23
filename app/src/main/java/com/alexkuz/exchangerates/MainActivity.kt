package com.alexkuz.exchangerates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(2000)
        setTheme(R.style.Theme_ExchangeRates)
        setContentView(R.layout.activity_main)
    }
}