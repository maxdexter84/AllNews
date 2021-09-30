package ru.maxdexter.allnews.di.fragment_modules.news

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.maxdexter.allnews.di.ViewModelKey
import ru.maxdexter.allnews.ui.fragments.news.NewsViewModel

@Module
abstract class NewsModule {
    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    abstract fun bindViewModel(viewModel: NewsViewModel): ViewModel
}