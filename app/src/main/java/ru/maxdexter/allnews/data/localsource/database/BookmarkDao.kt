package ru.maxdexter.allnews.data.localsource.database

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.maxdexter.allnews.data.localsource.model.Bookmark

@Dao
interface BookmarkDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(bookmark: Bookmark)

    @Query("SELECT * FROM bookmark")
    fun getAllBookmarks(): LiveData<List<Bookmark>>

    @Delete
    suspend fun deleteBookmark(bookmark: Bookmark)

    @Query("SELECT * FROM bookmark WHERE title = :title")
    suspend fun getBookmark(title: String): Bookmark

}