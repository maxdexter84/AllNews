package ru.maxdexter.allnews.domain.usecase

import ru.maxdexter.allnews.data.localsource.model.Bookmark

interface SaveToDbUseCase {
    suspend fun saveBookmark(bookmark: Bookmark)
}