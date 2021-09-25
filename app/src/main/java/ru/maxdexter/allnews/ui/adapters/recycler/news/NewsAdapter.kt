package ru.maxdexter.allnews.ui.adapters.recycler.news

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.maxdexter.allnews.ui.model.UINews

class NewsAdapter(private val click: (UINews) -> Unit) :
    ListAdapter<UINews, NewsViewHolder>(DiffNews()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val vh = NewsViewHolder.create(parent)
        vh.itemView.setOnClickListener {
            click.invoke(getItem(vh.absoluteAdapterPosition))
        }
        return vh
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(getItem(holder.absoluteAdapterPosition))
    }
}