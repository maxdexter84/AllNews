package ru.maxdexter.allnews.data.localsource.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.maxdexter.allnews.data.remotesource.model.Source
import java.io.Serializable
@Entity
data class Bookmark(
    var author: String = "",
    var content: String = "",
    var description: String = "",
    var publishedAt: String = "",
    var source: Source? = null,
    @PrimaryKey
    var title: String = "",
    var url: String = "",
    var urlToImage: String = "",
    var isBookmark: Boolean = false
) : Serializable