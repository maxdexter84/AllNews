package ru.maxdexter.allnews.domain.usecaseimpl

import ru.maxdexter.allnews.data.localsource.model.News
import ru.maxdexter.allnews.data.localsource.repository.LocalRepository
import ru.maxdexter.allnews.domain.common.mapToNews
import ru.maxdexter.allnews.domain.common.mapToUINews
import ru.maxdexter.allnews.domain.usecase.SaveAndReturnNewsUseCase
import ru.maxdexter.allnews.ui.model.UINews
import javax.inject.Inject

class SaveAndReturnNewsUseCaseImpl @Inject constructor(private val repository: LocalRepository): SaveAndReturnNewsUseCase {

    override suspend fun saveNews(news: News): UINews {
        return repository.saveNewsAndReturn(news).mapToUINews()
    }
}