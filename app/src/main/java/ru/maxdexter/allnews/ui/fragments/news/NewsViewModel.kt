package ru.maxdexter.allnews.ui.fragments.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import ru.maxdexter.allnews.domain.common.mapToNews
import ru.maxdexter.allnews.domain.usecase.GetCategoryNewsUseCase
import ru.maxdexter.allnews.domain.usecase.SaveAndReturnNewsUseCase
import ru.maxdexter.allnews.ui.adapters.pagingadapter.BreakingNewsPagingSource
import ru.maxdexter.allnews.ui.adapters.pagingadapter.BreakingNewsPagingSource.Companion.PAGE_SIZE
import ru.maxdexter.allnews.ui.model.UINews
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val useCase: GetCategoryNewsUseCase,
    private val saveAndReturnNewsUseCase: SaveAndReturnNewsUseCase
) : ViewModel() {
    private var currentCategory: String? = null
    private var currentSearchResult: Flow<PagingData<UINews>>? = null


    fun getNews(type: Int): Flow<PagingData<UINews>> {
        val lastResult = currentSearchResult
        if (lastResult != null && currentCategory == getCategory(type)) {
            return lastResult
        }
        currentCategory = getCategory(type)

        val newResult =
            pagingNews(getCategory(type)).cachedIn(viewModelScope)//cachedIn кеширует данные из результатов запроса
        currentSearchResult = newResult
        return newResult
    }

    private fun getCategory(type: Int): String {
        return listOf(
            "general",
            "business",
            "sports",
            "health",
            "science",
            "technology",
            "entertainment"
        )[type]
    }

    private fun pagingNews(category: String): Flow<PagingData<UINews>> {
        return Pager(config = PagingConfig(pageSize = PAGE_SIZE, enablePlaceholders = false),
            pagingSourceFactory = { BreakingNewsPagingSource(useCase, category) }).flow
    }

    fun saveNews(uiNews: UINews) {
        viewModelScope.launch {
            saveAndReturnNewsUseCase.saveNews(uiNews.mapToNews())
        }
    }

}