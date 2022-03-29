package com.alexkuz.exchangerates.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexkuz.exchangerates.model.Currency
import com.alexkuz.exchangerates.model.getCurrencies

class CurrencyViewModel : ViewModel() {

    private val _currencyList = MutableLiveData<List<Currency>>()
    val currencyList: LiveData<List<Currency>> get() = _currencyList

    fun onInitCurrencies() {
        _currencyList.postValue(getCurrencies())
    }


}