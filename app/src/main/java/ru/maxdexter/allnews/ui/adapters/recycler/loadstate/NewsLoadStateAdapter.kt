package ru.maxdexter.allnews.ui.adapters.recycler.loadstate

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import ru.maxdexter.allnews.ui.adapters.recycler.loadstate.LoadStateViewHolder

class NewsLoadStateAdapter(private val retry:()->Unit): LoadStateAdapter<LoadStateViewHolder>() {
    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        return LoadStateViewHolder.from(parent, retry)
    }
}