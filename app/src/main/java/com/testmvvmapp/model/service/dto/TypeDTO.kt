package com.testmvvmapp.model.service.dto

import com.testmvvmapp.model.service.entities.Type

data class TypeDTO(
    val key: String,
    val title: String
) {
    fun toType() = Type(key, title)
}