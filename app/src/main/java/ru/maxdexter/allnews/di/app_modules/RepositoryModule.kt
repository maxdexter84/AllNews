package ru.maxdexter.allnews.di.app_modules

import dagger.Binds
import dagger.Module
import ru.maxdexter.allnews.data.localsource.repository.LocalRepository
import ru.maxdexter.allnews.data.localsource.repository.LocalRepositoryImpl
import ru.maxdexter.allnews.data.remotesource.repository.RemoteRepository
import ru.maxdexter.allnews.data.remotesource.repository.RemoteRepositoryImpl

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindsLocalRepository(localRepositoryImpl: LocalRepositoryImpl): LocalRepository

    @Binds
    abstract fun bindsRemoteRepository(remoteRepositoryImpl: RemoteRepositoryImpl): RemoteRepository
}