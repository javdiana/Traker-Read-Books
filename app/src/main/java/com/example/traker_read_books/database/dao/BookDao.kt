package com.example.traker_read_books.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.traker_read_books.entity.Book

@Dao
interface BookDao {
    @Query("SELECT * FROM book")
    fun getAll(): LiveData<List<Book>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(book: Book)

    @Delete
    suspend fun remove(book: Book)
}