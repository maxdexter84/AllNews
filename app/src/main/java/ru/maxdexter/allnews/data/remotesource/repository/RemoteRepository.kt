package ru.maxdexter.allnews.data.remotesource.repository

import ru.maxdexter.allnews.data.remotesource.model.Article

interface RemoteRepository {
    suspend fun getBreakingNews(pageNumber: Int, pageSize: Int, category: String): List<Article>
    suspend fun searchNews(pageNumber: Int, pageSize: Int, query: String): List<Article>
}