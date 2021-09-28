package ru.maxdexter.allnews.domain.usecaseimpl

import androidx.lifecycle.LiveData
import ru.maxdexter.allnews.data.localsource.model.Bookmark
import ru.maxdexter.allnews.data.localsource.repository.LocalRepository
import ru.maxdexter.allnews.domain.usecase.GetBookmarksFromDbUseCase

class GetBookmarksFromDbUSeCaseImpl(private val repository: LocalRepository) :
    GetBookmarksFromDbUseCase {
    override fun getBookmarks(): LiveData<List<Bookmark>> {
        return repository.getAllBookmarks()
    }
}