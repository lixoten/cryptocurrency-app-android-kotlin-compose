package com.lixoten.cryptocurrencyappyt.presentation.coin_detail

import com.lixoten.cryptocurrencyappyt.domain.model.CoinDetail

data class CoinDetailUiState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
