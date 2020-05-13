package com.example.traker_read_books.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.traker_read_books.entity.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Delete
    suspend fun remove(user: User)
}