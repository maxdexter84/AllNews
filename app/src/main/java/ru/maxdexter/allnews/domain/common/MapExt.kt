package ru.maxdexter.allnews.domain.common

import ru.maxdexter.allnews.data.remotesource.model.Article
import ru.maxdexter.allnews.ui.model.UINews


fun Article.mapArticleToUINews(): UINews {
    return UINews(
        id = this.id ?: 0,
        author = this.author ?: "",
        content = this.content ?: "",
        description = this.description ?: "",
        publishedAt = this.publishedAt ?: "",
        source = this.source,
        title = this.title ?: "",
        url = this.url ?: "",
        urlToImage = this.urlToImage ?: ""
    )
}
