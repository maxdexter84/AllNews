package ru.maxdexter.allnews.domain.usecase

import ru.maxdexter.allnews.data.localsource.model.News
import ru.maxdexter.allnews.ui.model.UINews

interface SaveAndReturnNewsUseCase {
    suspend fun saveNews(news: News): UINews
}