package com.lixoten.cryptocurrencyappyt.presentation.coint_list

import com.lixoten.cryptocurrencyappyt.domain.model.Coin

data class CoinListUiState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
