package ru.maxdexter.allnews.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.maxdexter.allnews.di.app_modules.*
import ru.maxdexter.allnews.di.fragment_modules.news.NewsComponent

@Component(
    modules = [
        SubComponents::class,
        DatabaseModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        UseCaseModules::class,
        ViewModelBuilderModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun newsComponent(): NewsComponent.Factory
}