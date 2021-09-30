package ru.maxdexter.allnews.di.fragment_modules.search

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.maxdexter.allnews.di.ViewModelKey
import ru.maxdexter.allnews.ui.fragments.searchnews.SearchNewsViewModel

@Module
abstract class SearchModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchNewsViewModel::class)
    abstract fun bindViewModel(viewModel: SearchNewsViewModel): ViewModel
}