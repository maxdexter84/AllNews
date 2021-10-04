package ru.maxdexter.allnews.ui.fragments.history

import androidx.lifecycle.ViewModel
import ru.maxdexter.allnews.domain.usecase.DeleteHistoryUseCase
import ru.maxdexter.allnews.domain.usecase.GetHistoryUseCase
import javax.inject.Inject

class HistoryViewModel @Inject constructor(
    private val getHistoryUseCase: GetHistoryUseCase,
    private val deleteHistoryUseCase: DeleteHistoryUseCase
) : ViewModel() {

}