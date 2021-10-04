package ru.maxdexter.allnews.ui.adapters.recycler.bookmark

import androidx.recyclerview.widget.DiffUtil
import ru.maxdexter.allnews.ui.model.UINews

class DiffBookmarks : DiffUtil.ItemCallback<UINews>() {
    override fun areItemsTheSame(oldItem: UINews, newItem: UINews): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: UINews, newItem: UINews): Boolean {
        return oldItem.content == newItem.content
    }
}