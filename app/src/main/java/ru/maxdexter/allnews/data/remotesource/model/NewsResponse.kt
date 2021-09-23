package ru.maxdexter.allnews.data.remotesource.model

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)