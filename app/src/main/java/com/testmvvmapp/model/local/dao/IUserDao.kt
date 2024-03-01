package com.testmvvmapp.model.local.dao

import androidx.room.*
import com.testmvvmapp.model.entities.User

interface IUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)
    @Query("SELECT * FROM user")
    fun getAll(): List<User>
}