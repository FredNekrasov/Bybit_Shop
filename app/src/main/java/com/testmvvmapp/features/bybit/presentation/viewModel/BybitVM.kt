package com.testmvvmapp.features.bybit.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testmvvmapp.features.bybit.data.models.MainInfo
import com.testmvvmapp.features.bybit.data.repositories.IBybitRepository
import com.testmvvmapp.features.bybit.data.remote.util.ConnectionStatus
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class BybitVM(private val repository: IBybitRepository) : ViewModel() {
    private val resultMSF = MutableStateFlow(ConnectionStatus.LOADING to emptyList<MainInfo>())
    val resultSF = resultMSF.asStateFlow()
    init {
        getData()
    }
    fun getData() {
        viewModelScope.launch {
            repository.getData().collectLatest {
                resultMSF.emit(it)
            }
        }
    }
}