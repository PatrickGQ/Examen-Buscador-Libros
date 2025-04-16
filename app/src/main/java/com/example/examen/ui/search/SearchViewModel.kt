package com.example.examen.ui.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examen.data.repository.BookRepositoryImpl
import com.example.examen.domain.model.Book
import com.example.examen.usecases.SearchBooksUseCase
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchBooksUseCase: SearchBooksUseCase,
    private val repository: BookRepositoryImpl
) : ViewModel() {

    val searchQuery = mutableStateOf("")
    val books = mutableStateOf<List<Book>>(emptyList())

    fun onSearchQueryChanged(query: String) {
        searchQuery.value = query
    }

    fun searchBooks() {
        viewModelScope.launch {
            try {
                val result = searchBooksUseCase(searchQuery.value)
                books.value = result
            } catch (e: Exception) {
            }
        }
    }

    fun saveBook(book: Book) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveBook(book)
        }
    }
}