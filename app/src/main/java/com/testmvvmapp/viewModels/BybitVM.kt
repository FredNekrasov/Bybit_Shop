package com.testmvvmapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testmvvmapp.model.entities.MainInfo
import com.testmvvmapp.model.repository.IBybitRepository
import com.testmvvmapp.model.service.util.ConnectionStatus
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