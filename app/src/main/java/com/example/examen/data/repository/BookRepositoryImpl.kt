package com.example.examen.data.repository

import com.example.examen.data.local.dao.BookDao
import com.example.examen.data.local.mapper.toDomain
import com.example.examen.data.local.mapper.toEntity
import com.example.examen.data.remote.api.BookApiService
import com.example.examen.data.remote.mapper.toDomain
import com.example.examen.domain.model.Book
import com.example.examen.domain.repository.BookRepository
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val api: BookApiService,
    private val bookDao: BookDao
) : BookRepository {
    override suspend fun searchBooks(query: String): List<Book> {
        return api.searchBooks(query).docs.map { it.toDomain() }
    }

    suspend fun saveBook(book: Book) {
        bookDao.insert(book.toEntity())
    }

    suspend fun getSavedBooks(): List<Book> {
        return bookDao.getAll().map { it.toDomain() }
    }
}