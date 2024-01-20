package com.social.tradein.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.social.tradein.domain.repository.CoinRepository
import com.social.tradein.presentation.viewmodel.CoinViewModel
import com.social.tradein.presentation.viewmodel.ViewModelProviderFactory
import com.social.tradein.ui.theme.TradeInTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TradeInTheme {
            }
        }

        val repository = CoinRepository()
        val vmFactory = ViewModelProviderFactory(repository)
        val viewModel : CoinViewModel by viewModels { vmFactory }

        viewModel.coins.observe(this, Observer { res ->
            res.let {
                Log.d("vm", "fetching")
                Log.d("list", it[0].toString())
                Log.d("vm", "success")
            }
        })
    }
}
