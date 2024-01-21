package com.testmvvmapp.model.repository

import com.testmvvmapp.model.util.ConnectionStatus
import com.testmvvmapp.model.service.IService
import com.testmvvmapp.model.entities.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class Repository(private val api: IService) : IRepository {
    private val scope = CoroutineScope(Dispatchers.IO)
    override fun getData(): StateFlow<Pair<ConnectionStatus, Result?>> {
        val stateFlow = MutableStateFlow<Pair<ConnectionStatus, Result?>>(Pair(ConnectionStatus.LOADING, null))
        scope.launch {
            try {
                val result = api.get().execute()
                if (result.isSuccessful) {
                    val body = result.body() ?: return@launch stateFlow.emit(Pair(ConnectionStatus.NO_DATA, null))
                    stateFlow.emit(Pair(ConnectionStatus.SUCCESS, body.resultDTO.toResult()))
                }
            } catch (e: IOException) {
                stateFlow.emit(Pair(ConnectionStatus.CONNECTION_ERROR, null))
            } catch (e: HttpException) {
                stateFlow.emit(Pair(ConnectionStatus.NO_INTERNET, null))
            } catch (e: Exception) {
                stateFlow.emit(Pair(ConnectionStatus.UNKNOWN, null))
            }
        }
        return stateFlow
    }
}