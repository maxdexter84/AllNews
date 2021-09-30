package ru.maxdexter.allnews.di

import dagger.Module
import ru.maxdexter.allnews.di.fragment_modules.bookmarks.BookmarksComponent
import ru.maxdexter.allnews.di.fragment_modules.detail.DetailComponent
import ru.maxdexter.allnews.di.fragment_modules.news.NewsComponent
import ru.maxdexter.allnews.di.fragment_modules.search.SearchComponent

@Module(
    subcomponents = [
        NewsComponent::class,
        DetailComponent::class,
        SearchComponent::class,
        BookmarksComponent::class

    ]
)
object SubComponents