package ru.maxdexter.allnews.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.maxdexter.allnews.di.app_modules.*
import ru.maxdexter.allnews.di.fragment_modules.bookmarks.BookmarksComponent
import ru.maxdexter.allnews.di.fragment_modules.detail.DetailComponent
import ru.maxdexter.allnews.di.fragment_modules.history.HistoryComponent
import ru.maxdexter.allnews.di.fragment_modules.news.NewsComponent
import ru.maxdexter.allnews.di.fragment_modules.search.SearchComponent

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
        fun create(
            @BindsInstance context: Context,
            @BindsInstance application: Application
        ): AppComponent
    }

    fun newsComponent(): NewsComponent.Factory
    fun bookmarksComponent(): BookmarksComponent.Factory
    fun searchComponent(): SearchComponent.Factory
    fun detailComponent(): DetailComponent.Factory
    fun historyComponent(): HistoryComponent.Factory
}