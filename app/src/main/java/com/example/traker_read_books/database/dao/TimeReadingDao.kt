package com.example.traker_read_books.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.traker_read_books.entity.TimeReading

@Dao
interface TimeReadingDao {
    @Query("SELECT * FROM time_reading")
    fun getAll(): LiveData<List<TimeReading>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(timeReading: TimeReading)

    @Delete
    suspend fun remove(timeReading: TimeReading)
}