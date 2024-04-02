package com.testmvvmapp.bybit.data.repositories

import com.testmvvmapp.bybit.data.models.MainInfo
import com.testmvvmapp.bybit.data.remote.util.ConnectionStatus
import kotlinx.coroutines.flow.StateFlow

interface IBybitRepository {
    suspend fun getData(): StateFlow<Pair<ConnectionStatus, List<MainInfo>>>
}