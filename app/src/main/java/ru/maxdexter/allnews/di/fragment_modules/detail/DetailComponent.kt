package ru.maxdexter.allnews.di.fragment_modules.detail

import dagger.Subcomponent
import ru.maxdexter.allnews.ui.fragments.detail.DetailFragment

@Subcomponent(modules = [DetailModule::class])
interface DetailComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): DetailComponent
    }

    fun inject(fragment: DetailFragment)
}