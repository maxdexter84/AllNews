package ru.maxdexter.allnews.di.fragment_modules.search

import dagger.Subcomponent
import ru.maxdexter.allnews.ui.fragments.searchnews.SearchNewsFragment

@Subcomponent(modules = [SearchModule::class])
interface SearchComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): SearchComponent
    }

    fun inject(fragment: SearchNewsFragment)
}