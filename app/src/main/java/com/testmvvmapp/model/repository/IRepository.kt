package com.testmvvmapp.model.repository

import com.testmvvmapp.model.service.util.ConnectionStatus
import com.testmvvmapp.model.entities.Result
import kotlinx.coroutines.flow.StateFlow

interface IRepository {
    fun getData(): StateFlow<Pair<ConnectionStatus, Result?>>
}