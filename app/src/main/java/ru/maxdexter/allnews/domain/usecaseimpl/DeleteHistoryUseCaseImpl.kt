package ru.maxdexter.allnews.domain.usecaseimpl

import ru.maxdexter.allnews.data.localsource.repository.LocalRepository
import ru.maxdexter.allnews.domain.usecase.DeleteHistoryUseCase
import javax.inject.Inject

class DeleteHistoryUseCaseImpl @Inject constructor(private val repository: LocalRepository) :
    DeleteHistoryUseCase {
    override suspend fun deleteHistory() {
        repository.deleteHistory()
    }
}