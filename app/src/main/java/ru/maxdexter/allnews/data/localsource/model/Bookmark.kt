package ru.maxdexter.allnews.data.localsource.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.maxdexter.allnews.data.remotesource.model.Source
import java.io.Serializable
@Entity
data class Bookmark(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var author: String? = null,
    var content: String? = null,
    var description: String? = null,
    var publishedAt: String? = null,
    var source: Source? = null,
    var title: String? = null,
    var url: String? = null,
    var urlToImage: String? = null,
    var isBookmark: Boolean = false
) : Serializable