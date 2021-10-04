package ru.maxdexter.allnews.di.fragment_modules.history

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.maxdexter.allnews.di.ViewModelKey
import ru.maxdexter.allnews.ui.fragments.history.HistoryViewModel

@Module
abstract class HistoryModule {
    @Binds
    @IntoMap
    @ViewModelKey(HistoryViewModel::class)
    abstract fun bindViewModel(viewModel: HistoryViewModel): ViewModel
}