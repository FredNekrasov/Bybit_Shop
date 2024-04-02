package com.testmvvmapp.bybit.data.remote.dto

data class ResultDTO(
    val list: List<MainInfoDTO>,
    val total: Int
)