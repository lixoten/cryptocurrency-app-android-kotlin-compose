package com.lixoten.cryptocurrencyappyt.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lixoten.cryptocurrencyappyt.common.Constants
import com.lixoten.cryptocurrencyappyt.common.Resource
import com.lixoten.cryptocurrencyappyt.domain.use_case.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewmodel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = mutableStateOf(CoinDetailUiState())
    val uiState: State<CoinDetailUiState> = _uiState

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoin(coinId = coinId)
        }
    }

    private fun getCoin(coinId: String) {
        getCoinUseCase(coinId = coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _uiState.value = CoinDetailUiState(coin = result.data)
                }
                is Resource.Error -> {
                    _uiState.value = CoinDetailUiState(
                        error = result.message ?: "An unexpected Error occurred"
                    )
                }
                is Resource.Loading -> {
                    _uiState.value = CoinDetailUiState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}