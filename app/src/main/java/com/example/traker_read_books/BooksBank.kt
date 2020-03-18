package com.example.traker_read_books

import com.example.traker_read_books.entity.Book
import com.example.traker_read_books.entity.Language
import com.example.traker_read_books.entity.ReadingState

object BooksBank {
    private val books = ArrayList<Book>()

    init {
        setbooks()
    }

    fun setbooks(){
        val book1 = Book(1, "5 languages", "Gary Chempern", Language.Russian, 109, false, 2L,
            listOf(ReadingState("WED",false), ReadingState("TH", false)))
        val book2 = Book(2, "Healing of love 6", "Helen Vesnina", Language.Russian, 347, false, 6L,
        listOf(ReadingState("TH", false), ReadingState("FR", false), ReadingState("SA", false)
            ,ReadingState("SU", false)))
        val book3 = Book(3, "Healing of love 7", "Helen Vesnina", Language.Russian, 345, false, 6L,
            listOf(ReadingState("TH", false), ReadingState("FR", false)))
        val book4 = Book(4, "Healing of love 8", "Helen Vesnina", Language.Russian, 209, false, 6L,
            listOf(ReadingState("FR", false), ReadingState("SA", false)))
        val book5 = Book(5, "Influence of psychology", "Robers Tchaldini", Language.Russian, 109, false, 7L,
            listOf(ReadingState("FR", false), ReadingState("SA", false), ReadingState("SU", false)))
        books.addAll(listOf(book1, book2, book3, book4, book5))
    }

    fun getBooks(): List<Book> {
        return books
    }
}