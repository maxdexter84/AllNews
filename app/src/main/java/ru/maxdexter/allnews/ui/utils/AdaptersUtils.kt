package ru.maxdexter.allnews.ui.utils

import android.content.Context
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import ru.maxdexter.allnews.databinding.NewsFragmentBinding
import ru.maxdexter.allnews.ui.adapters.recycler.news.NewsAdapter

fun NewsAdapter.loadStateListener(binding: NewsFragmentBinding, context: Context) {
    this.addLoadStateListener { loadState ->
        // Показывать список можно только в том случае, если обновление прошло успешно.
        binding.rvNewsFragment.isVisible = loadState.source.refresh is LoadState.NotLoading
        // Показать загрузочный счетчик во время начальной загрузки или обновления.
        binding.paginationProgressBar.isVisible = loadState.source.refresh is LoadState.Loading
        // Покажите состояние повтора, если начальная загрузка или обновление завершатся неудачно.
        binding.btnRetrySearch.isVisible = loadState.source.refresh is LoadState.Error
        handlerParseLoadState(loadState, context)
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