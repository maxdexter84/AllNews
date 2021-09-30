package ru.maxdexter.allnews.di.fragment_modules.bookmarks

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.maxdexter.allnews.di.ViewModelKey
import ru.maxdexter.allnews.ui.fragments.bookmarks.BookmarksViewModel

@Module
abstract class BookmarksModule {
    @Binds
    @IntoMap
    @ViewModelKey(BookmarksViewModel::class)
    abstract fun bindsViewModel(viewModel: BookmarksViewModel): ViewModel
}