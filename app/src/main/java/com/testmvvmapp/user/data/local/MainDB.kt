package com.testmvvmapp.user.data.local

import androidx.room.*
import com.testmvvmapp.user.data.local.entity.User
import com.testmvvmapp.user.data.local.dao.IUserDao

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class MainDB : RoomDatabase() {
    abstract val userDao: IUserDao
    companion object {
        const val DB_NAME = "main.db"
    }
}