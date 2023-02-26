package com.lixoten.cryptocurrencyappyt.data.remote

import com.lixoten.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import com.lixoten.cryptocurrencyappyt.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    // Notes: Install PLUGIN: "JSON to kotlin Class"
    //  - this plugin helps us generate the DTO.. the data class for a record
    //  - multiple options of set up, phillips seems to be using "gson", select fiends only as needed option too
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    // "coinId" url path parameter
    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}