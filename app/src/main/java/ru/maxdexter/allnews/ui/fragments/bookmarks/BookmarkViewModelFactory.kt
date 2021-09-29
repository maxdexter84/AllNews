package ru.maxdexter.allnews.ui.fragments.bookmarks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.maxdexter.allnews.domain.usecase.GetBookmarksUseCase

class BookmarkViewModelFactory(
    private val getBookmarksUseCase: GetBookmarksUseCase
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BookmarksViewModel(getBookmarksUseCase) as T
    }
}