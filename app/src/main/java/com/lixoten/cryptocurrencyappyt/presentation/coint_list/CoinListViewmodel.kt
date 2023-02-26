package com.lixoten.cryptocurrencyappyt.presentation.coint_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lixoten.cryptocurrencyappyt.common.Resource
import com.lixoten.cryptocurrencyappyt.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewmodel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _uiState = mutableStateOf(CoinListUiState())
    val uiState: State<CoinListUiState> = _uiState

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _uiState.value = CoinListUiState(coins = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _uiState.value = CoinListUiState(
                        error = result.message ?: "An unexpected Error occurred"
                    )
                }
                is Resource.Loading -> {
                    _uiState.value = CoinListUiState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}