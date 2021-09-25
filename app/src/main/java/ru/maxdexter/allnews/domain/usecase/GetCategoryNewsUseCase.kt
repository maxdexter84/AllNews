package ru.maxdexter.allnews.domain.usecase

import ru.maxdexter.allnews.ui.model.UINews

interface GetCategoryNewsUseCase {
    suspend fun getCategoryNews(pageNumber: Int, pageSize: Int, category: String): List<UINews>
}