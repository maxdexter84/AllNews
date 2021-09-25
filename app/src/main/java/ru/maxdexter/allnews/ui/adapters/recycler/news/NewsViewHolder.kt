package ru.maxdexter.allnews.ui.adapters.recycler.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.maxdexter.allnews.databinding.ItemNewsPreviewBinding
import ru.maxdexter.allnews.ui.model.UINews

class NewsViewHolder(private val binding: ItemNewsPreviewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item:UINews){
        binding.apply {
            tvDescription.text = item.description
            tvTitle.text = item.title
            tvPublishedAt.text = item.publishedAt
            tvSource.text = item.author
        }
    }


    companion object{
        fun create(parent: ViewGroup): NewsViewHolder{
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemNewsPreviewBinding.inflate(inflater,parent, false)
            return NewsViewHolder(binding)
        }
    }
}