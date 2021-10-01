package ru.maxdexter.allnews.di.app_modules

import android.app.Application
import dagger.Module
import dagger.Provides
import ru.maxdexter.allnews.data.remotesource.api.NewsAPI
import ru.maxdexter.allnews.data.remotesource.api.RetrofitInstance
import ru.maxdexter.allnews.ui.utils.NetworkCheck

@Module
class NetworkModule {

    @Provides
    fun provideNewsApi(): NewsAPI {
        return RetrofitInstance.api
    }

    @Provides
    fun providesNetworkCheck(application: Application): NetworkCheck {
        return NetworkCheck(application)
    }
}