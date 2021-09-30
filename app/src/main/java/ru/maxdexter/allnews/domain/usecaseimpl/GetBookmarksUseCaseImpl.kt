package ru.maxdexter.allnews.domain.usecaseimpl

import ru.maxdexter.allnews.data.localsource.model.News
import ru.maxdexter.allnews.data.localsource.repository.LocalRepository
import ru.maxdexter.allnews.domain.usecase.GetBookmarksUseCase
import javax.inject.Inject

class GetBookmarksUseCaseImpl @Inject constructor(private val repository: LocalRepository): GetBookmarksUseCase {
    override fun getBookmarks(isBookmarks: Boolean): List<News> {
        return repository.getBookmark(isBookmarks)
    }
}