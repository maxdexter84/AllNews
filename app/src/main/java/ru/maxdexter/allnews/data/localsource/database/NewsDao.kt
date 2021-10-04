package ru.maxdexter.allnews.data.localsource.database

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.maxdexter.allnews.data.localsource.model.News

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(news: News)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(news: News)

    @Query("SELECT * FROM news")
    fun getAllNews(): LiveData<List<News>>

    @Query("SELECT * FROM news WHERE title = :title")
    fun getNews(title: String): News

    @Delete
    suspend fun deleteNews(news: News)

    @Transaction
    suspend fun saveAndReturn(news: News): News {
        insert(news)
        return getNews(news.title)
    }

    @Query("SELECT * FROM news WHERE isBookmark = :isBookmark")
    fun getBookmarks(isBookmark: Boolean): List<News>

    @Query("DELETE FROM news WHERE isBookmark = :isBookmark")
    fun deleteNewsIfItIsNotBookmark(isBookmark: Boolean)
}