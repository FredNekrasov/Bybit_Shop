package com.testmvvmapp.model.service.dto

data class ByBitDTO(
    val result: ResultDTO,
    val retCode: Int,
    val retMsg: String,
    val time: Long
)