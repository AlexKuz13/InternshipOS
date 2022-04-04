package com.alexkuz.exchangerates.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexkuz.exchangerates.domain.CurrenciesRepository
import com.alexkuz.exchangerates.model.Currency
import com.alexkuz.exchangerates.util.NetworkResult
import kotlinx.coroutines.launch


class CurrencyViewModel(
    private val repository: CurrenciesRepository
) : ViewModel() {

    private val _currencyList = MutableLiveData<List<Currency>>()
    val currencyList: LiveData<List<Currency>> get() = _currencyList

    private val _currencyListLoading = MutableLiveData(true)
    val currencyListLoading: LiveData<Boolean> get() = _currencyListLoading

    private val _currencyListError = MutableLiveData<String>()
    val currencyListError: LiveData<String> get() = _currencyListError

    fun onInitCurrencies() {
        viewModelScope.launch {
            when (val result = repository.getCurrencies()) {
                is NetworkResult.Error -> _currencyListError.value = result.message!!
                is NetworkResult.Success -> _currencyList.value =
                    result.data?.currency?.values?.toList()
            }
            _currencyListLoading.value = false
        }
    }

}