package com.example.examen.data.local.mapper

import com.example.examen.data.local.entity.BookEntity
import com.example.examen.domain.model.Book

fun BookEntity.toDomain(): Book {
    return Book(
        title = title,
        authors = authors.split(", "),
        publishYear = publishYear
    )
}

fun Book.toEntity(): BookEntity {
    return BookEntity(
        title = title,
        authors = authors.joinToString(", "),
        publishYear = publishYear
    )
}