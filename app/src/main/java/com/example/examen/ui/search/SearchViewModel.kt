package com.example.examen.ui.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examen.domain.model.Book
import com.example.examen.usecases.SearchBooksUseCase
import kotlinx.coroutines.launch

class SearchViewModel(
    private val searchBooksUseCase: SearchBooksUseCase
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
                // Log de error, si querés
            }
        }
    }
}