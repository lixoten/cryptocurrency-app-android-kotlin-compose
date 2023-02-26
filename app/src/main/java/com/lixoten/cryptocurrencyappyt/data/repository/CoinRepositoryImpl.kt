package com.lixoten.cryptocurrencyappyt.data.repository

import com.lixoten.cryptocurrencyappyt.data.remote.CoinPaprikaApi
import com.lixoten.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import com.lixoten.cryptocurrencyappyt.data.remote.dto.CoinDto
import com.lixoten.cryptocurrencyappyt.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoin(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId = coinId)
    }
}