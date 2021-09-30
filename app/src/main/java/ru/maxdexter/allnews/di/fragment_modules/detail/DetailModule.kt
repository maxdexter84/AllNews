package ru.maxdexter.allnews.di.fragment_modules.detail

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.maxdexter.allnews.di.ViewModelKey
import ru.maxdexter.allnews.ui.fragments.detail.DetailViewModel

@Module
abstract class DetailModule {

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindsViewModel(viewModel: DetailViewModel): ViewModel
}