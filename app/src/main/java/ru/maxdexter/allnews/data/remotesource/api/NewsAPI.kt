package ru.maxdexter.allnews.data.remotesource.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.maxdexter.allnews.data.remotesource.api.RetrofitInstance.Companion.API_KEY
import ru.maxdexter.allnews.data.remotesource.model.NewsResponse

interface NewsAPI {
//https://newsapi.org/v2/top-headlines?country=us&apiKey=a1a721d908b2412eb541dc137936049e

    @GET("v2/top-headlines?country=ru&apiKey=a1a721d908b2412eb541dc137936049e")
    suspend fun getBreakingNews(
        @Query("page") pageNumber: Int,
        @Query("category") category: String = "general",
        @Query("pageSize") pageSize: Int = 20
    ): NewsResponse


    @GET("v2/everything?language=ru&apiKey=a1a721d908b2412eb541dc137936049e")
    suspend fun searchingNews(
        @Query("q") searchQuery: String,
        @Query("page") pageNumber: Int,
        @Query("pageSize") pageSize: Int = 20
    ): NewsResponse
}