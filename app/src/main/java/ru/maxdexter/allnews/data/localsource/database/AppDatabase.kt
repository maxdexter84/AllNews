package ru.maxdexter.allnews.data.localsource.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.maxdexter.allnews.data.localsource.model.Bookmark
import ru.maxdexter.allnews.data.localsource.model.News

@Database(entities = [News::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getNewsDao(): NewsDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_db.db"
        ).build()
    }
}