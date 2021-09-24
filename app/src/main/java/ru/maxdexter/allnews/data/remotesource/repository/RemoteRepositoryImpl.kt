package ru.maxdexter.allnews.data.remotesource.repository

import ru.maxdexter.allnews.data.remotesource.api.NewsAPI
import ru.maxdexter.allnews.data.remotesource.model.Article

class RemoteRepositoryImpl(private val api: NewsAPI) : RemoteRepository {

    override suspend fun getBreakingNews(
        pageNumber: Int,
        pageSize: Int,
        category: String
    ): List<Article> {
        return api.getBreakingNews(
            pageNumber = pageNumber,
            pageSize = pageSize,
            category = category
        ).articles
    }

    override suspend fun searchNews(
        pageNumber: Int,
        pageSize: Int,
        query: String
    ): List<Article> {
        return api.searchingNews(
            searchQuery = query,
            pageNumber = pageNumber,
            pageSize = pageSize
        ).articles
    }
}