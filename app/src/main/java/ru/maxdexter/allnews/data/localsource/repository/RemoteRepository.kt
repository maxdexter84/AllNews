package ru.maxdexter.allnews.data.localsource.repository

import ru.maxdexter.allnews.data.remotesource.model.NewsResponse

interface RemoteRepository {
    suspend fun getBreakingNews(): NewsResponse
    suspend fun searchNews(): NewsResponse
}