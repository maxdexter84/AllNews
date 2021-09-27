package ru.maxdexter.allnews.ui.utils

import android.content.Context
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.viewbinding.ViewBinding
import androidx.viewbinding.ViewBindings
import ru.maxdexter.allnews.databinding.FragmentSearchBinding
import ru.maxdexter.allnews.databinding.NewsFragmentBinding
import ru.maxdexter.allnews.ui.adapters.recycler.news.NewsAdapter

fun NewsAdapter.loadStateListener(binding: ViewBinding, context: Context) {
    this.addLoadStateListener { loadState ->
        when(binding){
            is NewsFragmentBinding -> {
                // Показывать список можно только в том случае, если обновление прошло успешно.
                binding.rvNews.isVisible = loadState.source.refresh is LoadState.NotLoading
                // Показать загрузочный счетчик во время начальной загрузки или обновления.
                binding.paginationProgressBar.isVisible = loadState.source.refresh is LoadState.Loading
                // Покажите состояние повтора, если начальная загрузка или обновление завершатся неудачно.
                binding.btnRetrySearch.isVisible = loadState.source.refresh is LoadState.Error
                handlerParseLoadState(loadState, context)
            }
            is FragmentSearchBinding -> {
                // Показывать список можно только в том случае, если обновление прошло успешно.
                binding.rvSearchNews.isVisible = loadState.source.refresh is LoadState.NotLoading
                // Показать загрузочный счетчик во время начальной загрузки или обновления.
                binding.paginationProgressBar.isVisible = loadState.source.refresh is LoadState.Loading
                // Покажите состояние повтора, если начальная загрузка или обновление завершатся неудачно.
                binding.btnRetrySearch.isVisible = loadState.source.refresh is LoadState.Error
                handlerParseLoadState(loadState, context)
            }
        }

    }

}

private fun handlerParseLoadState(
    loadState: CombinedLoadStates,
    context: Context
) {
    // Тост по любой ошибке, независимо от того, исходила ли она от RemoteMediator или PagingSource
    val errorState = loadState.source.append as? LoadState.Error
        ?: loadState.source.prepend as? LoadState.Error
        ?: loadState.append as? LoadState.Error
        ?: loadState.prepend as? LoadState.Error
    errorState?.let {
        Toast.makeText(
            context,
            "\uD83D\uDE28 Uooops ${it.error}",
            Toast.LENGTH_LONG
        ).show()
    }
}