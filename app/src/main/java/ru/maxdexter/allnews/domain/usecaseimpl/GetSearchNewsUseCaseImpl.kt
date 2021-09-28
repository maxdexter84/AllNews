package ru.maxdexter.allnews.domain.usecaseimpl

import ru.maxdexter.allnews.data.remotesource.repository.RemoteRepository
import ru.maxdexter.allnews.domain.usecase.GetSearchNewsUseCase
import ru.maxdexter.allnews.ui.model.UINews

class GetSearchNewsUseCaseImpl(private val repository: RemoteRepository) : GetSearchNewsUseCase {
    override suspend fun getSearchNews(
        pageNumber: Int,
        pageSize: Int,
        query: String
    ): List<UINews> {
        return repository.searchNews(pageNumber, pageSize, query)
    }

}