package com.testmvvmapp.model.service.entities

data class MainInfo(
    val dateTimestamp: Long,
    val description: String,
    val endDateTimestamp: Long,
    val startDateTimestamp: Long,
    val tags: List<String>,
    val title: String,
    val type: Type,
    val url: String
)
