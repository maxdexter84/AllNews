package ru.maxdexter.allnews.ui.model

import ru.maxdexter.allnews.data.remotesource.model.Source
import java.io.Serializable


data class UINews(
    var id: Int,
    var author: String = "",
    var content: String = "",
    var description: String = "",
    var publishedAt: String = "",
    var source: Source? = null,
    var title: String = "",
    var url: String = "",
    var urlToImage: String = ""
) : Serializable