package com.example.examen.usecases

import com.example.examen.domain.model.Book
import com.example.examen.domain.repository.BookRepository

class SearchBooksUseCase(private val repository: BookRepository) {
    suspend operator fun invoke(query: String): List<Book> {
        return repository.searchBooks(query)
    }
}