package ru.maxdexter.allnews.domain.usecase

import ru.maxdexter.allnews.data.localsource.model.News

interface SaveNewsUseCase {
    suspend fun saveNews(news: News)
}