package ru.maxdexter.allnews.data.remotesource.repository

import ru.maxdexter.allnews.data.remotesource.model.Article
import ru.maxdexter.allnews.ui.model.UINews

interface RemoteRepository {
    suspend fun getBreakingNews(pageNumber: Int, pageSize: Int, category: String): List<UINews>
    suspend fun searchNews(pageNumber: Int, pageSize: Int, query: String): List<UINews>
}