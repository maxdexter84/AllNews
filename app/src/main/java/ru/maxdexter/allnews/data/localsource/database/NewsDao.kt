package ru.maxdexter.allnews.data.localsource.database

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.maxdexter.allnews.data.localsource.model.News

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(news: News): Long

    @Query("SELECT * FROM news")
    fun getAllArticles(): LiveData<List<News>>

    @Delete
    suspend fun deleteArticle(news: News): Int


}