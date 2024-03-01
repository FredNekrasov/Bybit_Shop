package com.testmvvmapp.model.local

import androidx.room.*
import com.testmvvmapp.model.entities.User
import com.testmvvmapp.model.local.dao.*
import javax.inject.Singleton

@Singleton
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class MainDB : RoomDatabase() {
    abstract val userDao: IUserDao
    companion object {
        const val DB_NAME = "main.db"
    }
}