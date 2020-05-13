package com.example.traker_read_books.repository

import androidx.lifecycle.LiveData
import com.example.traker_read_books.database.dao.BookDao
import com.example.traker_read_books.entity.Book

class BookRepository(private val bookDao: BookDao) {
    val allBooks: LiveData<List<Book>> = bookDao.getAll();

    suspend fun insertBook(book: Book) {
        bookDao.insert(book)
    }

}