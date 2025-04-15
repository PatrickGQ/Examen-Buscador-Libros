package com.example.examen.data.repository

import com.example.examen.data.remote.api.BookApiService
import com.example.examen.data.remote.mapper.toDomain
import com.example.examen.domain.model.Book
import com.example.examen.domain.repository.BookRepository

class BookRepositoryImpl(
    private val api: BookApiService
) : BookRepository {
    override suspend fun searchBooks(query: String): List<Book> {
        return api.searchBooks(query).docs.map { it.toDomain() }
    }
}