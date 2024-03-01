package com.testmvvmapp.model.repository

import com.testmvvmapp.model.entities.User

interface UserRepository {
    fun signUp(user: User): User?
    fun logIn(userName: String, password: String): User?
}