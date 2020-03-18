package com.example.traker_read_books.entity

data class Book(
    val id: Long,
    val name: String,
    val author: String,
    val language: Language,
    val pages: Int,
    val isReadBook: Boolean,
    val timeToRead: Long,
    val readingStates: List<ReadingState>
)