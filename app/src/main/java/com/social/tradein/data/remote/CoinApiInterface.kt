package com.social.tradein.data.remote

import androidx.lifecycle.LiveData
import com.social.tradein.data.models.CoinDetailsResponse
import com.social.tradein.data.models.CoinResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface CoinApiInterface {

    @GET("coins")
    suspend fun getCoins() : Response<CoinResponse>

    @GET
    suspend fun getCoinDetails(@Url URL : String) : Response<CoinDetailsResponse>
}