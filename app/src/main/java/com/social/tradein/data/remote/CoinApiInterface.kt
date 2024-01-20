package com.social.tradein.data.remote

import androidx.lifecycle.LiveData
import com.social.tradein.data.models.CoinDetailsResponse
import com.social.tradein.data.models.CoinResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApiInterface {

    @GET("coins")
    suspend fun getCoins() : Response<CoinResponse>

    @GET("coins/{symbol}")
    suspend fun getCoinDetails(@Path("symbol") symbol : String) : Response<CoinDetailsResponse>
}