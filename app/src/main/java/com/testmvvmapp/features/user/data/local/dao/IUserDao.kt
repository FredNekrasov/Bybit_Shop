package com.testmvvmapp.features.user.data.local.dao

import androidx.room.*
import com.testmvvmapp.features.user.data.local.entity.User

@Dao
interface IUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)
    @Query("SELECT * FROM user")
    fun getAll(): List<User>
}