package com.testmvvmapp.user.data.repositories

import com.testmvvmapp.user.data.local.entity.User

interface UserRepository {
    fun signUp(user: User): User?
    fun logIn(userName: String, password: String): User?
}