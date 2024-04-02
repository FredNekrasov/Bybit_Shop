package com.testmvvmapp.features.bybit.data.remote.dto

data class ByBitDTO(
    val result: ResultDTO,
    val retCode: Int,
    val retMsg: String,
    val time: Long
)