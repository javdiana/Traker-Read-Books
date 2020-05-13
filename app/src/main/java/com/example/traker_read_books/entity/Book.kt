package com.example.traker_read_books.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
data class Book(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val name: String,
    val author: String,
    val pages: Int
)