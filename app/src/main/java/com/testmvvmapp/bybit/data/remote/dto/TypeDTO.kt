package com.testmvvmapp.bybit.data.remote.dto

import com.testmvvmapp.bybit.data.models.Type

data class TypeDTO(
    val key: String,
    val title: String
) {
    fun toType() = Type(key, title)
}