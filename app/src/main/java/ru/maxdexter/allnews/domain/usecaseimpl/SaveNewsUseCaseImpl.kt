package ru.maxdexter.allnews.domain.usecaseimpl

import ru.maxdexter.allnews.data.localsource.model.News
import ru.maxdexter.allnews.data.localsource.repository.LocalRepository
import ru.maxdexter.allnews.domain.usecase.SaveNewsUseCase
import javax.inject.Inject

class SaveNewsUseCaseImpl @Inject constructor(private val localRepository: LocalRepository) :
    SaveNewsUseCase {
    override suspend fun saveNews(news: News) {
        localRepository.saveNews(news)
    }
}