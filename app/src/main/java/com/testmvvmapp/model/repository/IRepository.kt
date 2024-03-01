package com.testmvvmapp.model.repository

import com.testmvvmapp.model.entities.MainInfo
import com.testmvvmapp.model.service.util.ConnectionStatus
import kotlinx.coroutines.flow.StateFlow

interface IRepository {
    suspend fun getData(): StateFlow<Pair<ConnectionStatus, List<MainInfo>>>
}