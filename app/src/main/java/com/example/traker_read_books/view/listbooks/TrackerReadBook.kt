package com.example.traker_read_books.view.listbooks

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TrackerReadBook : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@TrackerReadBook)
        }

        injectFeature()
    }
}