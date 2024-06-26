package com.testmvvmapp.features.user.data.local.entity

import androidx.room.*

@Entity
data class User(
    val userName: String,
    val password: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    @PrimaryKey val id: Int? = null
)