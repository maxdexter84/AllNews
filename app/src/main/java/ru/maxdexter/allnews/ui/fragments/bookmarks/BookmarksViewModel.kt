package ru.maxdexter.allnews.ui.fragments.bookmarks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.maxdexter.allnews.domain.common.mapToUINews
import ru.maxdexter.allnews.domain.usecase.GetBookmarksUseCase
import ru.maxdexter.allnews.ui.model.UINews

class BookmarksViewModel(
    private val getBookmarksUseCase: GetBookmarksUseCase

) : ViewModel() {

    private val _data = MutableLiveData<List<UINews>>()
    val data: LiveData<List<UINews>>
        get() = _data

    init {
        loadData()
    }
     fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            _data.postValue(getBookmarksUseCase.getBookmarks(true).map { it.mapToUINews() })
        }
    }
}