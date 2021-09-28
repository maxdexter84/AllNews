package ru.maxdexter.allnews.domain.usecaseimpl

import ru.maxdexter.allnews.data.localsource.model.News
import ru.maxdexter.allnews.data.localsource.repository.LocalRepository
import ru.maxdexter.allnews.domain.usecase.GetBookmarksUseCase

class GetBookmarksUseCaseImpl(private val repository: LocalRepository): GetBookmarksUseCase {
    override fun getBookmarks(isBookmarks: Boolean): List<News> {
        return repository.getBookmark(isBookmarks)
    }
}