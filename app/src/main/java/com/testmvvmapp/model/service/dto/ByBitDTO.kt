package com.testmvvmapp.model.service.dto

data class ByBitDTO(
    val resultDTO: ResultDTO,
    val retCode: Int,
    val retMsg: String,
    val time: Long
)