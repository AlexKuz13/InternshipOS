package com.alexkuz.exchangerates.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexkuz.exchangerates.domain.CurrenciesRepository
import com.alexkuz.exchangerates.model.Currency
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CurrencyViewModel(
    private val repository: CurrenciesRepository
) : ViewModel() {

    private val _currencyList = MutableLiveData<List<Currency>>()
    val currencyList: LiveData<List<Currency>> get() = _currencyList

    fun onInitCurrencies() {
        viewModelScope.launch(Dispatchers.IO) {
            _currencyList.postValue(repository.getCurrencies().currency.values.toList())
        }
    }


}