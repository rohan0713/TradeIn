package com.social.tradein.data.remote

import com.social.tradein.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {

        val retrofit by lazy {

            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

            Retrofit.Builder()
                .baseUrl(Constants.url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api: CoinApiInterface by lazy {
            retrofit.create(CoinApiInterface::class.java)
        }
    }
}