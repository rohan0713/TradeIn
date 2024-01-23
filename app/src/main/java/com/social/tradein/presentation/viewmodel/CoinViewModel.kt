package com.social.tradein.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.social.tradein.data.models.CoinDetailsResponse
import com.social.tradein.data.models.CoinResponse
import com.social.tradein.domain.repository.CoinRepository
import kotlinx.coroutines.launch

class CoinViewModel(
    private val repository: CoinRepository
) : ViewModel() {

    private val _coins : MutableLiveData<CoinResponse> = MutableLiveData<CoinResponse>()
    val coins : LiveData<CoinResponse> = _coins

    private val _coinDetails : MutableLiveData<CoinDetailsResponse> = MutableLiveData<CoinDetailsResponse>()
    val coinDetails : LiveData<CoinDetailsResponse> = _coinDetails

    init {
        fetchCoin()
    }

    private fun fetchCoin() {
        viewModelScope.launch {
            val response = repository.getCoins()
            if(response.isSuccessful){
                Log.d("vm", "success")
                _coins.postValue(response.body())
                Log.d("vm", "fetched")
            }
        }
    }

    suspend fun fetchCoinDetails(URL: String) {
        viewModelScope.launch {
            val response = repository.getCoinDetails(URL)
            if(response.isSuccessful){
                _coinDetails.postValue(response.body())
            }
        }
    }
}