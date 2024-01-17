package com.testmvvmapp.model.service.dto

import com.squareup.moshi.Json

data class ByBitDTO(
    @field:Json(name = "result")
    val resultDTO: ResultDTO,
    val retCode: Int,
    val retMsg: String,
    val time: Long
)