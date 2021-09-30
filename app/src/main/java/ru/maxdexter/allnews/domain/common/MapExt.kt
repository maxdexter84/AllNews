package ru.maxdexter.allnews.domain.common

import ru.maxdexter.allnews.data.localsource.model.Bookmark
import ru.maxdexter.allnews.data.localsource.model.News
import ru.maxdexter.allnews.data.remotesource.model.Article
import ru.maxdexter.allnews.ui.model.UINews


fun Article.mapArticleToUINews(): UINews {
    return UINews(
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

fun UINews.mapToBookmark(): Bookmark {
    return Bookmark(
        author, content, description, publishedAt, source, title, url, urlToImage, true
    )
}

fun Bookmark.mapToUINews(): UINews {
    return UINews(
        author, content, description, publishedAt, source, title, url, urlToImage, isBookmark
    )
}

fun UINews.mapToNews(): News {
    return News(
        author, content, description, publishedAt, source, title, url, urlToImage, isBookmark
    )
}

fun News.mapToUINews(): UINews {
    return UINews(
        author, content, description, publishedAt, source, title, url, urlToImage, isBookmark
    )
}

fun Bookmark.mapToNews():News {
    return News(
        author, content, description, publishedAt, source, title, url, urlToImage, isBookmark
    )
}
