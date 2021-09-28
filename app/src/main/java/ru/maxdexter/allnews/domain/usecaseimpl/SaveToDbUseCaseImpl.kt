package ru.maxdexter.allnews.domain.usecaseimpl

import ru.maxdexter.allnews.data.localsource.model.Bookmark
import ru.maxdexter.allnews.data.localsource.repository.LocalRepository
import ru.maxdexter.allnews.data.remotesource.repository.RemoteRepository
import ru.maxdexter.allnews.domain.usecase.SaveToDbUseCase

class SaveToDbUseCaseImpl(private val repository: LocalRepository) : SaveToDbUseCase {
    override suspend fun saveBookmark(bookmark: Bookmark) {
        repository.insertBookmark(bookmark)
    }
}