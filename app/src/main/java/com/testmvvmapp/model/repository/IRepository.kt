package com.testmvvmapp.model.repository

import com.testmvvmapp.model.internet.ConnectionStatus
import com.testmvvmapp.model.service.entities.Result
import kotlinx.coroutines.flow.StateFlow

interface IRepository {
    fun getData(): StateFlow<Pair<ConnectionStatus, Result?>>
}