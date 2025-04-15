package com.example.examen.ui.saved

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.examen.domain.model.Book
import com.example.examen.ui.search.components.BookItem

@Composable
fun SavedBooksScreen(getSavedBooks: suspend () -> List<Book>) {
    var savedBooks by remember { mutableStateOf<List<Book>>(emptyList()) }

    LaunchedEffect(Unit) {
        savedBooks = getSavedBooks()
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text(text = "Libros guardados", modifier = Modifier.padding(bottom = 16.dp))

        LazyColumn {
            items(savedBooks) { book ->
                BookItem(book = book, onLikeClick = {}) // sin botón funcional por ahora
            }
        }
    }
}