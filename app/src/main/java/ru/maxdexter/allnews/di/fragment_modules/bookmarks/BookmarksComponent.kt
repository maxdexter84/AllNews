package ru.maxdexter.allnews.di.fragment_modules.bookmarks

import dagger.Subcomponent
import ru.maxdexter.allnews.ui.fragments.bookmarks.BookmarksFragment

@Subcomponent(modules = [BookmarksModule::class])
interface BookmarksComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): BookmarksComponent
    }

    fun inject(fragment: BookmarksFragment)
}