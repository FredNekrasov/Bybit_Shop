package com.testmvvmapp.features.bybit.data.repositories

import com.testmvvmapp.features.bybit.data.models.MainInfo
import com.testmvvmapp.features.bybit.data.remote.util.ConnectionStatus
import kotlinx.coroutines.flow.StateFlow

interface IBybitRepository {
    suspend fun getData(): StateFlow<Pair<ConnectionStatus, List<MainInfo>>>
}