package ru.maxdexter.allnews.ui.fragments.searchnews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.*
import ru.maxdexter.allnews.domain.usecase.GetSearchNewsUseCase
import ru.maxdexter.allnews.ui.adapters.pagingadapter.SearchingNewsPagingSource
import ru.maxdexter.allnews.ui.model.UINews

class SearchNewsViewModel(private val useCase: GetSearchNewsUseCase) : ViewModel() {

    private var currentQuery: String? = null
    private var currentSearchResult: Flow<PagingData<UINews>>? = null

    fun getNews(query: String): Flow<PagingData<UINews>> {
        val lastResult = currentSearchResult
        if (lastResult != null && currentQuery == query) {
            return lastResult
        }
        currentQuery = query

        val newResult =
            pagingNews(query).cachedIn(viewModelScope)//cachedIn кеширует данные из результатов запроса
        currentSearchResult = newResult
        return newResult
    }

    private fun pagingNews(query: String): Flow<PagingData<UINews>> {
        return Pager(config = PagingConfig(
            pageSize = SearchingNewsPagingSource.PAGE_SIZE,
            enablePlaceholders = false
        ),
            pagingSourceFactory = { SearchingNewsPagingSource(useCase, query) }).flow
    }
}