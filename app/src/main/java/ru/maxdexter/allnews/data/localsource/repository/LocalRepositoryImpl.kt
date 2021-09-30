package ru.maxdexter.allnews.data.localsource.repository

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import ru.maxdexter.allnews.data.localsource.database.NewsDao
import ru.maxdexter.allnews.data.localsource.model.News
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(private val newsDao: NewsDao) :
    LocalRepository {


    override fun getAllNews(): LiveData<List<News>> {
        return newsDao.getAllNews()
    }

    override suspend fun getNews(title: String): News {
        return newsDao.getNews(title)
    }

    override suspend fun deleteNews(news: News) {
        newsDao.deleteNews(news)
    }

    override suspend fun saveNewsAndReturn(news: News): News {
        return newsDao.saveAndReturn(news)
    }

    override suspend fun saveNews(news: News) {
        newsDao.save(news)
    }

    override fun getBookmark(isBookmark: Boolean): List<News> {
        return newsDao.getBookmarks(isBookmark)
    }
}