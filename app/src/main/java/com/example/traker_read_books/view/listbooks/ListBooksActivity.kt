package com.example.traker_read_books.view.listbooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.traker_read_books.R
import org.koin.android.viewmodel.ext.android.viewModel

class ListBooksActivity : AppCompatActivity() {
    private val listBookViewModel: ListBookViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
