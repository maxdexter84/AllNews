package ru.maxdexter.allnews

import android.app.Application
import android.content.Context
import ru.maxdexter.allnews.di.AppComponent
import ru.maxdexter.allnews.di.DaggerAppComponent

class App: Application() {
    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(applicationContext)
    }

    val Context.appComponent: AppComponent
        get() = when (this) {
            is App -> appComponent
            else -> applicationContext.appComponent
        }
}