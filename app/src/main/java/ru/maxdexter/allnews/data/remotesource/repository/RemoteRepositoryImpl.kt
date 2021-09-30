package ru.maxdexter.allnews.data.remotesource.repository

import ru.maxdexter.allnews.data.remotesource.api.NewsAPI
import ru.maxdexter.allnews.domain.common.mapArticleToUINews
import ru.maxdexter.allnews.ui.model.UINews
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(private val api: NewsAPI) : RemoteRepository {

    override suspend fun getBreakingNews(
        pageNumber: Int,
        pageSize: Int,
        category: String
    ): List<UINews> {
        return api.getBreakingNews(
            pageNumber = pageNumber,
            pageSize = pageSize,
            category = category
        ).articles.map { it.mapArticleToUINews() }
    }

    override suspend fun searchNews(
        pageNumber: Int,
        pageSize: Int,
        query: String
    ): List<UINews> {
        return api.searchingNews(
            searchQuery = query,
            pageNumber = pageNumber,
            pageSize = pageSize
        ).articles.map { it.mapArticleToUINews() }
    }
}