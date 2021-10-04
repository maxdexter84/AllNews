package ru.maxdexter.allnews.domain.usecase

import ru.maxdexter.allnews.data.localsource.model.News

interface GetBookmarksUseCase {
    suspend fun getBookmarks(isBookmarks: Boolean): List<News>
}