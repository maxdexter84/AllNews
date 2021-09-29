package ru.maxdexter.allnews.ui.fragments.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.maxdexter.allnews.domain.usecase.GetCategoryNewsUseCase
import ru.maxdexter.allnews.domain.usecase.SaveAndReturnNewsUseCase

@Suppress("UNCHECKED_CAST")
class NewsViewModelFactory(
    private val useCase: GetCategoryNewsUseCase,
    private val saveAndReturnNewsUseCase: SaveAndReturnNewsUseCase
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(useCase, saveAndReturnNewsUseCase) as T
    }
}