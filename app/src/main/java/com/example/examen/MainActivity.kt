package com.example.examen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.examen.data.remote.api.RetrofitInstance
import com.example.examen.data.repository.BookRepositoryImpl
import com.example.examen.ui.search.SearchScreen
import com.example.examen.ui.search.SearchViewModel
import com.example.examen.usecases.SearchBooksUseCase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = BookRepositoryImpl(RetrofitInstance.api)
        val searchBooksUseCase = SearchBooksUseCase(repository)
        val viewModel = SearchViewModel(searchBooksUseCase)

        setContent {
            SearchScreen(viewModel = viewModel)
        }
    }
}