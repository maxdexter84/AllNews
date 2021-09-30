package ru.maxdexter.allnews.domain.usecase

import kotlinx.coroutines.flow.Flow
import ru.maxdexter.allnews.ui.model.UINews

interface GetSearchNewsUseCase {
    suspend fun getSearchNews(pageNumber: Int, pageSize: Int, query: String): List<UINews>
}