package com.lixoten.cryptocurrencyappyt.domain.model

// only map what we need from CoinDto
data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)

