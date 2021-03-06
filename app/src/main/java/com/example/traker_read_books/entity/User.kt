package com.example.traker_read_books.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstNane: String,
    val lastNane: String,
    val age: Int
)