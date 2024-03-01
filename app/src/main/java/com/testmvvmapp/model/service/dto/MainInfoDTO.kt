package com.testmvvmapp.model.service.dto

import com.testmvvmapp.model.entities.MainInfo

data class MainInfoDTO(
    val dateTimestamp: Long,
    val description: String,
    val endDateTimestamp: Long,
    val startDateTimestamp: Long,
    val tags: List<String>,
    val title: String,
    val type: TypeDTO,
    val url: String
) {
    fun toMainInfo() = MainInfo(dateTimestamp, description, endDateTimestamp, startDateTimestamp, tags, title, type.toType(), url)
}