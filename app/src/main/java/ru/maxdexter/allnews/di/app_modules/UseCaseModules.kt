package ru.maxdexter.allnews.di.app_modules

import dagger.Binds
import dagger.Module
import ru.maxdexter.allnews.domain.usecase.*
import ru.maxdexter.allnews.domain.usecaseimpl.*

@Module
abstract class UseCaseModules {
    @Binds
    abstract fun bindBookmarksUSeCase(getBookmarksUseCaseImpl: GetBookmarksUseCaseImpl): GetBookmarksUseCase

    @Binds
    abstract fun bindCategoryUseCase(getCategoryNewsUseCaseImpl: GetCategoryNewsUseCaseImpl): GetCategoryNewsUseCase

    @Binds
    abstract fun bindGetNewsFromDbById(getNewsFromDbByIdImpl: GetNewsFromDbByIdImpl): GetNewsFromDbById

    @Binds
    abstract fun bindGetSearchNewsUseCase(getSearchNewsUseCaseImpl: GetSearchNewsUseCaseImpl): GetSearchNewsUseCase

    @Binds
    abstract fun bindSaveAndReturnNewsUseCase(saveAndReturnNewsUseCaseImpl: SaveAndReturnNewsUseCaseImpl): SaveAndReturnNewsUseCase

    @Binds
    abstract fun bindSaveNewsUseCase(saveNewsUseCaseImpl: SaveNewsUseCaseImpl): SaveNewsUseCase
}