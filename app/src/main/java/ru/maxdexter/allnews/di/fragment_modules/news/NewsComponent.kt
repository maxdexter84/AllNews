package ru.maxdexter.allnews.di.fragment_modules.news

import dagger.Subcomponent
import ru.maxdexter.allnews.ui.fragments.news.NewsFragment

@Subcomponent(modules = [NewsModule::class])
interface NewsComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): NewsComponent
    }

    fun inject(fragment: NewsFragment)
}