package ru.maxdexter.allnews.di

import dagger.Module
import ru.maxdexter.allnews.di.fragment_modules.news.NewsComponent

@Module(subcomponents = [
NewsComponent::class
])
object SubComponents