package ru.maxdexter.allnews.di.app_modules

import dagger.Module
import dagger.Provides
import ru.maxdexter.allnews.data.remotesource.api.NewsAPI
import ru.maxdexter.allnews.data.remotesource.api.RetrofitInstance

@Module
class NetworkModule {

    @Provides
    fun provideNewsApi(): NewsAPI{
        return RetrofitInstance.api
    }
}