package ru.maxdexter.allnews.data.localsource.repository

import androidx.lifecycle.LiveData
import ru.maxdexter.allnews.data.localsource.model.Bookmark
import ru.maxdexter.allnews.data.localsource.model.News

interface LocalRepository {

    suspend fun insertBookmark(bookmark: Bookmark)
    fun getAllBookmarks(): LiveData<List<Bookmark>>
    suspend fun deleteBookmark(bookmark: Bookmark)


    suspend fun insertArticle(news: List<News>): Long
    fun getAllArticles(): LiveData<List<News>>
    suspend fun deleteArticle(news: News): Int
}