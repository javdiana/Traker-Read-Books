package com.example.traker_read_books.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.traker_read_books.database.dao.BookDao
import com.example.traker_read_books.database.dao.DayReadingDao
import com.example.traker_read_books.database.dao.TimeReadingDao
import com.example.traker_read_books.database.dao.UserDao
import com.example.traker_read_books.entity.Book
import com.example.traker_read_books.entity.DayReading
import com.example.traker_read_books.entity.TimeReading
import com.example.traker_read_books.entity.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(
    entities = [Book::class, User::class, DayReading::class, TimeReading::class],
    version = 1,
    exportSchema = false
)
abstract class TrackerReadBookDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
    abstract fun userDao(): UserDao
    abstract fun dayReadingDao(): DayReadingDao
    abstract fun timeReadingDao(): TimeReadingDao

    private class TrackerReadBookDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.bookDao())
                }
            }
        }

        suspend fun populateDatabase(bookDao: BookDao) {
            val book1 = Book(1, "book1", "author1", 100)
            val book2 = Book(2, "book2", "author2", 100)
            val book3 = Book(3, "book3", "author3", 100)
            val book4 = Book(4, "book4", "author4", 100)

            bookDao.insert(book1)
            bookDao.insert(book2)
            bookDao.insert(book3)
            bookDao.insert(book4)
        }
    }

    companion object {
        @Volatile
        var INSTANCE: TrackerReadBookDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope) : TrackerReadBookDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TrackerReadBookDatabase::class.java,
                    "tracker_read_books"
                ).addCallback(TrackerReadBookDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}