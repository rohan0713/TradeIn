package com.social.tradein.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.social.tradein.domain.repository.CoinRepository

class ViewModelProviderFactory(
    private val repository: CoinRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CoinViewModel(repository = repository) as T
    }
}