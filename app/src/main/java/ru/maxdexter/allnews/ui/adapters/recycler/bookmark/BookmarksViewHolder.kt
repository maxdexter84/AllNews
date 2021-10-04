package ru.maxdexter.allnews.ui.adapters.recycler.bookmark

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.maxdexter.allnews.databinding.ItemNewsPreviewBinding
import ru.maxdexter.allnews.ui.model.UINews
import ru.maxdexter.allnews.ui.utils.setImage

class BookmarksViewHolder(private val binding: ItemNewsPreviewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: UINews) {
        binding.ivArticleImage.setImage(item.urlToImage)
        binding.tvTitle.text = item.title
        binding.tvPublishedAt.text = item.publishedAt

    }


    companion object {
        fun create(parent: ViewGroup): BookmarksViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemNewsPreviewBinding.inflate(inflater, parent, false)
            return BookmarksViewHolder(binding)
        }
    }
}