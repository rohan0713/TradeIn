package com.social.tradein.domain.repository

import androidx.lifecycle.LiveData
import com.social.tradein.data.models.CoinDetailsResponse
import com.social.tradein.data.models.CoinResponse
import com.social.tradein.data.remote.CoinApiInterface
import com.social.tradein.data.remote.RetrofitClient
import retrofit2.Response

class CoinRepository : CoinApiInterface {

    override suspend fun getCoins(): Response<CoinResponse> {
        return RetrofitClient.api.getCoins()
    }

    override suspend fun getCoinDetails(symbol: String): Response<CoinDetailsResponse> {
        return RetrofitClient.api.getCoinDetails(symbol)
    }
}