package ru.maxdexter.allnews.ui.fragments.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.maxdexter.allnews.domain.common.mapToNews
import ru.maxdexter.allnews.domain.common.mapToUINews
import ru.maxdexter.allnews.domain.usecase.GetNewsFromDbById
import ru.maxdexter.allnews.domain.usecase.SaveNewsUseCase
import ru.maxdexter.allnews.ui.model.UINews

class DetailViewModel(
    private val saveNewsUseCase: SaveNewsUseCase,
    private val getNewsFromDbById: GetNewsFromDbById
) : ViewModel() {

    private val _isBookmark = MutableLiveData<Boolean>()
    val isBookmark: LiveData<Boolean>
        get() = _isBookmark

    private val _news = MutableLiveData<UINews>()
    val news: LiveData<UINews>
        get() = _news

    fun saveBookmark() {
        viewModelScope.launch() {
            val bookmark = news.value?.isBookmark?.let { news.value?.copy(isBookmark = !it) }
            bookmark?.let {
                viewModelScope.launch {
                    saveNewsUseCase.saveNews(it.mapToNews())
                }
                _news.value = it
            }
            changeIcon()

//                saveBookmarkUseCase.saveBookmark(bookmark)
//                saveNewsUseCase.saveNews(bookmark.mapToNews())

        }
    }

    fun getNewsFromDatabase(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _news.postValue(getNewsFromDbById.getNews(id).mapToUINews())
        }
    }

    fun changeIcon() {
        _isBookmark.value = _news.value?.isBookmark
    }
}