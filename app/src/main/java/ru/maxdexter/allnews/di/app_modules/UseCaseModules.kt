package ru.maxdexter.allnews.di.app_modules

import dagger.Binds
import dagger.Module
import ru.maxdexter.allnews.domain.usecase.GetBookmarksUseCase
import ru.maxdexter.allnews.domain.usecase.GetCategoryNewsUseCase
import ru.maxdexter.allnews.domain.usecaseimpl.GetBookmarksUseCaseImpl
import ru.maxdexter.allnews.domain.usecaseimpl.GetCategoryNewsUseCaseImpl

@Module
abstract class UseCaseModules {
    @Binds
    abstract fun bindBookmarksUSeCase(getBookmarksUseCaseImpl: GetBookmarksUseCaseImpl): GetBookmarksUseCase

    @Binds
    abstract fun bindCategoryUseCase(getCategoryNewsUseCaseImpl: GetCategoryNewsUseCaseImpl): GetCategoryNewsUseCase
}