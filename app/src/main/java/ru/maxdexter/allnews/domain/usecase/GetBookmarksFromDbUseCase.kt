package ru.maxdexter.allnews.domain.usecase

import androidx.lifecycle.LiveData
import ru.maxdexter.allnews.data.localsource.model.Bookmark

interface GetBookmarksFromDbUseCase {
    fun getBookmarks(): LiveData<List<Bookmark>>
}