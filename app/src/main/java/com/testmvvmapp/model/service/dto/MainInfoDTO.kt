package com.testmvvmapp.model.service.dto

data class MainInfoDTO(
    val dateTimestamp: Long,
    val description: String,
    val endDateTimestamp: Long,
    val startDateTimestamp: Long,
    val tags: List<String>,
    val title: String,
    val typeDTO: TypeDTO,
    val url: String
)