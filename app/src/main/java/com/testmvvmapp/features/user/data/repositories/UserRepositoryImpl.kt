package com.testmvvmapp.features.user.data.repositories

import com.testmvvmapp.features.user.data.local.entity.User
import com.testmvvmapp.features.user.data.local.dao.IUserDao

class UserRepositoryImpl(private val dao: IUserDao) : UserRepository {
    override fun signUp(user: User): User? {
        val existedUser = dao.getAll().find { user.userName == it.userName && user.password == it.password }
        if (existedUser != null) return null
        dao.insert(user)
        return user
    }
    override fun logIn(
        userName: String,
        password: String
    ): User? = dao.getAll().find { userName == it.userName && password == it.password }
}