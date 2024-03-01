package com.testmvvmapp.model.local.dao

import com.testmvvmapp.model.entities.Result 
import androidx.room.*

interface IResultDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(result: Result)
    @Query("SELECT * FROM result")
    fun getAll(): List<Result>
    @Query("DELETE FROM result")
    fun deleteAll()
}