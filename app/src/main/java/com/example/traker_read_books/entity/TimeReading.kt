package com.example.traker_read_books.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "time_reading")
data class TimeReading(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
 //   val book: Book,
    val time: Long
)