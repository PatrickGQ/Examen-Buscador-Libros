package com.example.examen.domain.repository

import com.example.examen.domain.model.Book

interface BookRepository {
    suspend fun searchBooks(query: String): List<Book>
}