package ru.maxdexter.allnews.domain.usecase

import ru.maxdexter.allnews.data.localsource.model.News

interface GetNewsFromDbById {
    suspend fun getNews(id: String): News
}