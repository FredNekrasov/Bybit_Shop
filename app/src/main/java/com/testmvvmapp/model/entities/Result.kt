package com.testmvvmapp.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Result(
    val list: List<MainInfo>,
    val total: Int,
    val favorite: Boolean,
    @PrimaryKey val id: Int? = null
)