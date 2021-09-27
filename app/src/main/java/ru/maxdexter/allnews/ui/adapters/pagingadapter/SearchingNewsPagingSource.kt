package ru.maxdexter.allnews.ui.adapters.pagingadapter

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.maxdexter.allnews.domain.usecase.GetCategoryNewsUseCase
import ru.maxdexter.allnews.domain.usecase.GetSearchNewsUseCase
import ru.maxdexter.allnews.ui.model.UINews


class SearchingNewsPagingSource(
    private val useCase: GetSearchNewsUseCase,
    private val query: String
) :
    PagingSource<Int, UINews>() {
    override fun getRefreshKey(state: PagingState<Int, UINews>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UINews> {
        val position = params.key ?: START_PAGE
        return try {
            val res = useCase.getSearchNews(
                pageNumber = position,
                query = query,
                pageSize = params.loadSize,
            )
            val nextKey =
                if (res.isEmpty()) null else position + (params.loadSize / PAGE_SIZE)
            return LoadResult.Page(
                data = res,
                prevKey = if (position == START_PAGE) null else position - 1,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        const val PAGE_SIZE = 20
        const val START_PAGE = 1
    }
}