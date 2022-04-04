package com.alexkuz.exchangerates.di

import com.alexkuz.exchangerates.data.network.CurrencyApi
import com.alexkuz.exchangerates.util.Constants.BASE_URL
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { provideOkHttpClient() }
    factory { provideCurrencyApi(get()) }
    single { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().build()
}


fun provideCurrencyApi(retrofit: Retrofit): CurrencyApi =
    retrofit.create(CurrencyApi::class.java)
