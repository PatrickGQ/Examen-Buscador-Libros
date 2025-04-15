package com.example.examen.data.remote.api

import com.example.examen.data.remote.dto.BookSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApiService {
    @GET("search.json")
    suspend fun searchBooks(@Query("q") query: String): BookSearchResponse
}