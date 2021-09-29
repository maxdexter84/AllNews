package ru.maxdexter.allnews.domain.usecaseimpl

import ru.maxdexter.allnews.data.localsource.model.News
import ru.maxdexter.allnews.data.localsource.repository.LocalRepository
import ru.maxdexter.allnews.domain.usecase.GetNewsFromDbById
import ru.maxdexter.allnews.ui.model.UINews

class GetNewsFromDbByIdImpl(private val repository: LocalRepository): GetNewsFromDbById {
    override suspend fun getNews(id: String): News {
        return repository.getNews(id)
    }
}