package com.lixoten.cryptocurrencyappyt.domain.repository

import com.lixoten.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import com.lixoten.cryptocurrencyappyt.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoin(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}