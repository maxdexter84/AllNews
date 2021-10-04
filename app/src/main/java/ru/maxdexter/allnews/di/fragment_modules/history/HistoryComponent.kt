package ru.maxdexter.allnews.di.fragment_modules.history

import dagger.Subcomponent
import ru.maxdexter.allnews.ui.fragments.history.HistoryFragment

@Subcomponent(modules = [HistoryModule::class])
interface HistoryComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): HistoryComponent
    }

    fun inject(fragment: HistoryFragment)
}