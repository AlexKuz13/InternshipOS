package com.alexkuz.exchangerates.di

import com.alexkuz.exchangerates.ui.viewmodels.CurrencyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
        CurrencyViewModel(repository = get())
    }

}