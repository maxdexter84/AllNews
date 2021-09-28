package ru.maxdexter.allnews.ui.adapters.recycler.bookmark

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.ListAdapter
import ru.maxdexter.allnews.ui.adapters.recycler.news.DiffNews
import ru.maxdexter.allnews.ui.adapters.recycler.news.NewsViewHolder
import ru.maxdexter.allnews.ui.model.UINews

class BookmarksAdapter(private val click: (UINews) -> Unit) :
    ListAdapter<UINews, NewsViewHolder>(DiffNews()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val vh = NewsViewHolder.create(parent)
        vh.itemView.setOnClickListener {
            getItem(vh.absoluteAdapterPosition)?.let { news -> click.invoke(news) }
        }
        return vh
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}