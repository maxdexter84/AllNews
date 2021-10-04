package ru.maxdexter.allnews.ui.adapters.recycler.bookmark

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.maxdexter.allnews.ui.model.UINews

class BookmarksAdapter(private val click: (UINews) -> Unit) :
    ListAdapter<UINews, BookmarksViewHolder>(DiffBookmarks()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarksViewHolder {
        val vh = BookmarksViewHolder.create(parent)
        vh.itemView.setOnClickListener {
            getItem(vh.absoluteAdapterPosition)?.let { news -> click.invoke(news) }
        }
        return vh
    }

    override fun onBindViewHolder(holder: BookmarksViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}