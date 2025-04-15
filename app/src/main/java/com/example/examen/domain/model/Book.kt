package com.example.examen.domain.model

data class Book(
    val title: String,
    val authors: List<String>,
    val publishYear: Int
)