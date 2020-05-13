package com.example.traker_read_books.view.listbooks

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.traker_read_books.database.TrackerReadBookDatabase
import com.example.traker_read_books.entity.Book
import com.example.traker_read_books.repository.BookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListBookViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: BookRepository
    val allBooks: LiveData<List<Book>>

    init {
        val bookDao = TrackerReadBookDatabase.getDatabase(application, viewModelScope).bookDao()
        repository = BookRepository(bookDao)
        allBooks = repository.allBooks
    }

    fun insert(book: Book) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertBook(book)
    }
}