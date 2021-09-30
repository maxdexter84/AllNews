package ru.maxdexter.allnews.ui.fragments.searchnews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import ru.maxdexter.allnews.domain.common.mapToNews
import ru.maxdexter.allnews.domain.usecase.GetSearchNewsUseCase
import ru.maxdexter.allnews.domain.usecase.SaveAndReturnNewsUseCase
import ru.maxdexter.allnews.ui.adapters.pagingadapter.SearchingNewsPagingSource
import ru.maxdexter.allnews.ui.model.UINews
import javax.inject.Inject

class SearchNewsViewModel @Inject constructor(
    private val useCase: GetSearchNewsUseCase,
    private val saveAndReturnNewsUseCase: SaveAndReturnNewsUseCase
) : ViewModel() {

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

    fun saveNews(uiNews: UINews) {
        viewModelScope.launch {
            saveAndReturnNewsUseCase.saveNews(uiNews.mapToNews())
        }
    }
}