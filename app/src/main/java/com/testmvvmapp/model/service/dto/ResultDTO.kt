package com.testmvvmapp.model.service.dto

import com.testmvvmapp.model.entities.Result

data class ResultDTO(
    val list: List<MainInfoDTO>,
    val total: Int
) {
    fun toResult() = Result(list.map { it.toMainInfo() }, total)
}