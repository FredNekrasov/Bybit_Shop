package com.testmvvmapp.features.user.data.repositories

import com.testmvvmapp.features.user.data.local.entity.User

interface UserRepository {
    fun signUp(user: User): User?
    fun logIn(userName: String, password: String): User?
}