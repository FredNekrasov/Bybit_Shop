package com.testmvvmapp.features.bybit.data.remote.dto

import com.testmvvmapp.features.bybit.data.models.Type

data class TypeDTO(
    val key: String,
    val title: String
) {
    fun toType() = Type(key, title)
}