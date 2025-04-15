package com.example.examen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.room.Room
import com.example.examen.data.local.db.AppDatabase
import com.example.examen.data.remote.api.RetrofitInstance
import com.example.examen.data.repository.BookRepositoryImpl
import com.example.examen.ui.search.SearchScreen
import com.example.examen.ui.search.SearchViewModel
import com.example.examen.usecases.SearchBooksUseCase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "books_db"
        ).build()
        val repository = BookRepositoryImpl(
            RetrofitInstance.api,
            bookDao = database.bookDao()
        )
        val searchBooksUseCase = SearchBooksUseCase(repository)
        val viewModel = SearchViewModel(searchBooksUseCase)

        setContent {
            SearchScreen(viewModel = viewModel)
        }
    }
}