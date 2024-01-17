package com.testmvvmapp.model.service.dto

import com.testmvvmapp.model.service.entities.MainInfo

data class MainInfoDTO(
    val dateTimestamp: Long,
    val description: String,
    val endDateTimestamp: Long,
    val startDateTimestamp: Long,
    val tags: List<String>,
    val title: String,
    val typeDTO: TypeDTO,
    val url: String
) {
    fun toMainInfo(): MainInfo {
        return MainInfo(
            dateTimestamp,
            description,
            endDateTimestamp,
            startDateTimestamp,
            tags,
            title,
            typeDTO.toType(),
            url
        )
    }
}