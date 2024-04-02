package com.testmvvmapp.features.bybit.data.repositories

import com.testmvvmapp.features.bybit.data.models.MainInfo
import com.testmvvmapp.features.bybit.data.remote.IBybitService
import com.testmvvmapp.features.bybit.data.remote.util.ConnectionStatus
import kotlinx.coroutines.flow.*
import retrofit2.HttpException
import java.io.IOException

class BybitRepository(private val api: IBybitService) : IBybitRepository {
    override suspend fun getData(): StateFlow<Pair<ConnectionStatus,List<MainInfo>>> {
        val list = emptyList<MainInfo>()
        val data = MutableStateFlow(Pair(ConnectionStatus.LOADING, list))
        try {
            val res = api.get()
            if(res == null) data.emit(Pair(ConnectionStatus.NO_DATA, list))
            else {
                val entityList = res.result.list.map { it.toMainInfo() }
                data.emit(Pair(ConnectionStatus.SUCCESS, entityList))
            }
        } catch (e: IOException) {
            data.emit(Pair(ConnectionStatus.CONNECTION_ERROR, list))
        } catch (e: HttpException) {
            data.emit(Pair(ConnectionStatus.NO_INTERNET, list))
        } catch (e: Exception) {
            data.emit(Pair(ConnectionStatus.UNKNOWN, list))
        }
        return data
    }
}