package com.testmvvmapp.model.repository

import com.testmvvmapp.model.entities.MainInfo
import com.testmvvmapp.model.service.IService
import com.testmvvmapp.model.service.util.ConnectionStatus
import kotlinx.coroutines.flow.*
import retrofit2.HttpException
import java.io.IOException

class Repository(private val api: IService) : IRepository {
    override suspend fun getData(): StateFlow<Pair<ConnectionStatus,List<MainInfo>>> {
        val list = emptyList<MainInfo>()
        val data = MutableStateFlow(Pair(ConnectionStatus.LOADING,list))
        try {
            val res = api.get()
            if(res == null) data.emit(Pair(ConnectionStatus.NO_DATA,list))
            else {
                val entityList = res.result.list.map { it.toMainInfo() }
                data.emit(Pair(ConnectionStatus.SUCCESS,entityList))
            }
        } catch (e: IOException) {
            data.emit(Pair(ConnectionStatus.CONNECTION_ERROR,list))
        } catch (e: HttpException) {
            data.emit(Pair(ConnectionStatus.NO_INTERNET,list))
        } catch (e: Exception) {
            data.emit(Pair(ConnectionStatus.UNKNOWN,list))
        }
        return data
    }
}