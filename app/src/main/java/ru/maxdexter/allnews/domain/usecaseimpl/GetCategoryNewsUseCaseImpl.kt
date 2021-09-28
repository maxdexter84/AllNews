package ru.maxdexter.allnews.domain.usecaseimpl

import ru.maxdexter.allnews.data.remotesource.repository.RemoteRepository
import ru.maxdexter.allnews.domain.usecase.GetCategoryNewsUseCase
import ru.maxdexter.allnews.ui.model.UINews

class GetCategoryNewsUseCaseImpl(private val repository: RemoteRepository) :
    GetCategoryNewsUseCase {

    override suspend fun getCategoryNews(
        pageNumber: Int,
        pageSize: Int,
        category: String
    ): List<UINews> {
        return repository.getBreakingNews(pageNumber, pageSize, category)
    }
}