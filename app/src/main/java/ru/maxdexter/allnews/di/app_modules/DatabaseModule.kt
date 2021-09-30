package ru.maxdexter.allnews.di.app_modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.maxdexter.allnews.data.localsource.database.AppDatabase
import ru.maxdexter.allnews.data.localsource.database.NewsDao

@Module
class DatabaseModule {

    @Provides
    fun provideDatabase(context: Context): NewsDao {
        return AppDatabase.invoke(context).getNewsDao()
    }
}