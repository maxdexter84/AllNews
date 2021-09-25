package ru.maxdexter.allnews.domain.usecase

import ru.maxdexter.allnews.data.remotesource.model.Article

interface GetCategoryNewsUseCase {
    suspend fun getCategoryNews(pageNumber: Int, pageSize: Int, category: String): List<Article>
}