package ru.maxdexter.allnews.ui.fragments.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.maxdexter.allnews.domain.common.mapToUINews
import ru.maxdexter.allnews.domain.usecase.DeleteHistoryUseCase
import ru.maxdexter.allnews.domain.usecase.GetHistoryUseCase
import ru.maxdexter.allnews.ui.model.UINews
import javax.inject.Inject

class HistoryViewModel @Inject constructor(
    private val getHistoryUseCase: GetHistoryUseCase,
    private val deleteHistoryUseCase: DeleteHistoryUseCase
) : ViewModel() {

    private val _data = MutableLiveData<List<UINews>>()
    val data: LiveData<List<UINews>>
        get() = _data

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            _data.postValue(getHistoryUseCase.get().map { it.mapToUINews() })
        }
    }

    private fun deleteHistory() {
        viewModelScope.launch {
            deleteHistoryUseCase.deleteHistory()
        }
    }
}