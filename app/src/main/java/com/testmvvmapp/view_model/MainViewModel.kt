package com.testmvvmapp.view_model

import androidx.lifecycle.*
import com.testmvvmapp.model.entities.MainInfo
import com.testmvvmapp.model.service.util.ConnectionStatus
import com.testmvvmapp.model.repository.IRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: IRepository) : ViewModel() {
    private val resultMSF = MutableStateFlow(ConnectionStatus.LOADING to emptyList<MainInfo>())
    val resultSF = resultMSF.asStateFlow()
    init {
        getData()
    }
    fun getData() {
        viewModelScope.launch {
            delay(2000)
            repository.getData().collectLatest {
                resultMSF.emit(it)
            }
        }
    }
}