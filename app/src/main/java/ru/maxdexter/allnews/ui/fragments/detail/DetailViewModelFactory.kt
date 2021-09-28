package ru.maxdexter.allnews.ui.fragments.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.maxdexter.allnews.domain.usecase.GetNewsFromDbById
import ru.maxdexter.allnews.domain.usecase.SaveNewsUseCase

class DetailViewModelFactory(
    private val saveNewsUseCase: SaveNewsUseCase,
    private val getNewsFromDbById: GetNewsFromDbById
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailViewModel(saveNewsUseCase, getNewsFromDbById) as T
    }
}