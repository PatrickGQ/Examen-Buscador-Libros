package com.example.examen.data.remote.mapper


import com.example.examen.data.remote.dto.BookDto
import com.example.examen.domain.model.Book

fun BookDto.toDomain(): Book {
    return Book(
        title = title ?: "Sin título",
        authors = author_name ?: listOf("Autor desconocido"),
        publishYear = first_publish_year ?: 0
    )
}