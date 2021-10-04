package ru.maxdexter.allnews.data.localsource.repository

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import ru.maxdexter.allnews.data.localsource.model.News

interface LocalRepository {

    fun getAllNews(): LiveData<List<News>>
    suspend fun getNews(title: String): News
    suspend fun deleteNews(news: News)
    suspend fun saveNewsAndReturn(news: News): News
    suspend fun saveNews(news: News)
    suspend fun getBookmark(isBookmark: Boolean): List<News>
    suspend fun deleteHistory()
}