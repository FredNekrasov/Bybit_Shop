package com.testmvvmapp.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testmvvmapp.model.service.util.ConnectionStatus
import com.testmvvmapp.model.repository.IRepository
import com.testmvvmapp.model.entities.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: IRepository) : ViewModel() {
    private val resultMSF = MutableStateFlow<Pair<ConnectionStatus, Result?>>(ConnectionStatus.LOADING to null)
    val resultSF = resultMSF.asStateFlow()
    fun getData() {
        viewModelScope.launch {
            delay(2000)
            repository.getData().collectLatest {
                resultMSF.emit(it)
            }
        }
    }
}