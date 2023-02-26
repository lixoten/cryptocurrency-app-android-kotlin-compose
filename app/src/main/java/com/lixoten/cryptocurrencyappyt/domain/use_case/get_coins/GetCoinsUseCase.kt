package com.lixoten.cryptocurrencyappyt.domain.use_case.get_coins

import com.lixoten.cryptocurrencyappyt.common.Resource
import com.lixoten.cryptocurrencyappyt.data.remote.dto.toCoin
import com.lixoten.cryptocurrencyappyt.domain.model.Coin
import com.lixoten.cryptocurrencyappyt.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoin().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(data = coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check internet connection"))
        }
    }


}