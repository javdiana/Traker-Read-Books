package com.example.traker_read_books.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "day_reading")
data class DayReading(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val day: String,
    // val books: List<Map<Book, Boolean>>,
    val statusReading: Int
)