package ru.maxdexter.allnews.ui.adapters.recycler.news

import androidx.recyclerview.widget.DiffUtil
import ru.maxdexter.allnews.ui.model.UINews

class DiffNews: DiffUtil.ItemCallback<UINews>() {
    override fun areItemsTheSame(oldItem: UINews, newItem: UINews): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UINews, newItem: UINews): Boolean {
        return oldItem.content == newItem.content
    }
}