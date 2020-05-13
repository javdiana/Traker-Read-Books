package com.example.traker_read_books.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.traker_read_books.entity.DayReading

@Dao
interface DayReadingDao {
    @Query("SELECT * FROM day_reading")
    fun getAll(): LiveData<List<DayReading>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dayReading: DayReading)

    @Delete
    suspend fun remove(dayReading: DayReading)
}