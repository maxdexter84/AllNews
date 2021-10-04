package ru.maxdexter.allnews.domain.usecase

import ru.maxdexter.allnews.data.localsource.model.News

interface GetHistoryUseCase {
    suspend fun get(): List<News>
}