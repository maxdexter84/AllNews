package ru.maxdexter.allnews.ui.fragments.searchnews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.maxdexter.allnews.domain.usecase.GetSearchNewsUseCase
import ru.maxdexter.allnews.domain.usecase.SaveAndReturnNewsUseCase

class SearchNewsViewModelFactory(
    private val useCase: GetSearchNewsUseCase,
    private val saveAndReturnNewsUseCase: SaveAndReturnNewsUseCase
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SearchNewsViewModel(useCase, saveAndReturnNewsUseCase) as T
    }
}