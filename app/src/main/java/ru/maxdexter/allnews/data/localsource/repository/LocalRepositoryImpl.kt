package ru.maxdexter.allnews.data.localsource.repository

import androidx.lifecycle.LiveData
import ru.maxdexter.allnews.data.localsource.database.BookmarkDao
import ru.maxdexter.allnews.data.localsource.database.NewsDao
import ru.maxdexter.allnews.data.localsource.model.Bookmark
import ru.maxdexter.allnews.data.localsource.model.News

class LocalRepositoryImpl(private val bookmarkDao: BookmarkDao, private val newsDao: NewsDao) :
    LocalRepository {
    override suspend fun insertBookmark(bookmark: Bookmark) {
        bookmarkDao.insert(bookmark)
    }

    override fun getAllBookmarks(): LiveData<List<Bookmark>> {
        return bookmarkDao.getAllBookmarks()
    }

    override suspend fun deleteBookmark(bookmark: Bookmark) {
        bookmarkDao.deleteBookmark(bookmark)
    }

    override suspend fun insertArticle(news: List<News>) {
        newsDao.insert(news)
    }

    override fun getAllArticles(): LiveData<List<News>> {
        return newsDao.getAllArticles()
    }

    override suspend fun deleteArticle(news: News) {
        newsDao.deleteArticle(news)
    }
}