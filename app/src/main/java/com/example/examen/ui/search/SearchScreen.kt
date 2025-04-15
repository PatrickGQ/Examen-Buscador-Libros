package com.example.examen.ui.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.examen.ui.search.components.BookItem

@Composable
fun SearchScreen(viewModel: SearchViewModel, onNavigateToSaved: () -> Unit) {
    val searchQuery by viewModel.searchQuery
    val books by viewModel.books

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        TextField(
            value = searchQuery,
            onValueChange = viewModel::onSearchQueryChanged,
            label = { Text("Buscar libro") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = onNavigateToSaved,
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Ver guardados")
        }
        Button(
            onClick = { viewModel.searchBooks() },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Buscar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(books) { book ->
                BookItem(book = book, onLikeClick = { viewModel.saveBook(it) })
            }
        }
    }
}