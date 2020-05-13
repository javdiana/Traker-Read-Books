package com.example.traker_read_books.view.listbooks

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.traker_read_books.R
import com.example.traker_read_books.entity.Book

class ListBooksActivity : AppCompatActivity() {
    private lateinit var bookViewModel: ListBookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bookViewModel = ViewModelProvider(this).get(ListBookViewModel::class.java)
        bookViewModel.allBooks.observe(this, Observer { books ->
            run {
                books?.let {
                    it.forEach { book ->
                        run {
                            showToast(book)
                        }
                    }
                }
            }
        })


    }

    fun showToast(book: Book) {
        Toast.makeText(this, book.name, Toast.LENGTH_LONG).show()
    }
}
