package com.example.traker_read_books.entity

class User(
    val id: Long,
    val firstNane: String,
    val lastNane: String,
    val age: Int,
    val books: List<Book>
)