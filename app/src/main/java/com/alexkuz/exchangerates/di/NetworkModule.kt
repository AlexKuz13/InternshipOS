package com.alexkuz.exchangerates.di

import com.alexkuz.exchangerates.data.network.CurrencyApi
import com.alexkuz.exchangerates.util.Constants.Companion.BASE_URL
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { provideInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideCurrencyApi(get()) }
    single { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(interceptor).build()
}

fun provideInterceptor(): Interceptor {
    return Interceptor { chain ->
        val url = chain.request()
            .url()
            .newBuilder()
            .build()

        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()

        return@Interceptor chain.proceed(request)
    }
}

fun provideCurrencyApi(retrofit: Retrofit): CurrencyApi =
    retrofit.create(CurrencyApi::class.java)
