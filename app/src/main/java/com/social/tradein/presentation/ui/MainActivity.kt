package com.social.tradein.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import com.social.tradein.domain.repository.CoinRepository
import com.social.tradein.presentation.viewmodel.CoinViewModel
import com.social.tradein.presentation.viewmodel.ViewModelProviderFactory
import com.social.tradein.ui.theme.TradeInTheme

class MainActivity : ComponentActivity() {

    private val viewModel: CoinViewModel by viewModels {
        ViewModelProviderFactory(CoinRepository())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TradeInTheme {
                WindowCompat.setDecorFitsSystemWindows(window, false)
                AppNavigation(viewModel)
            }
        }
    }
}
