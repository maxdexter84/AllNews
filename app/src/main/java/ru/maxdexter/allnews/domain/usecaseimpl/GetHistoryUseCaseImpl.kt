package ru.maxdexter.allnews.domain.usecaseimpl

import ru.maxdexter.allnews.data.localsource.model.News
import ru.maxdexter.allnews.data.localsource.repository.LocalRepository
import ru.maxdexter.allnews.domain.usecase.GetHistoryUseCase

class GetHistoryUseCaseImpl(private val repository: LocalRepository) : GetHistoryUseCase {
    override fun get(): List<News> {
       return repository.getBookmark(false)
    }
}