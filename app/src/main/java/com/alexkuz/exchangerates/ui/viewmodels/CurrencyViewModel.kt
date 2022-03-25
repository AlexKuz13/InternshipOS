package com.alexkuz.exchangerates.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexkuz.exchangerates.model.Currency
import com.alexkuz.exchangerates.model.getCurrencies

class CurrencyViewModel : ViewModel() {

    private val listCurrencies: MutableLiveData<List<Currency>> by lazy {
        MutableLiveData<List<Currency>>()
    }

    fun getListCurrencies(): LiveData<List<Currency>>{
        listCurrencies.value = getCurrencies()
        return listCurrencies
    }


}