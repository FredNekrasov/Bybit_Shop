package com.testmvvmapp.model.local

import androidx.room.*
import com.testmvvmapp.model.entities.User
import com.testmvvmapp.model.local.dao.*
import com.testmvvmapp.model.local.type_converters.ResultConverter
import javax.inject.Singleton

@Singleton
@Database(entities = [Result::class, User::class], version = 1, exportSchema = false)
@TypeConverters(ResultConverter::class)
abstract class MainDB : RoomDatabase() {
    abstract val resultDao: IResultDao
    abstract val userDao: IUserDao
    companion object {
        const val DB_NAME = "main.db"
    }
}