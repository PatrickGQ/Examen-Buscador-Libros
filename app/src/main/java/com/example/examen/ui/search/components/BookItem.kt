package com.example.examen.ui.search.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.examen.domain.model.Book

@Composable
fun BookItem(
    book: Book,
    onLikeClick: ((Book) -> Unit)? = null
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Título: ${book.title}", style = MaterialTheme.typography.titleMedium)
            Text(text = "Autor: ${book.authors.joinToString()}")
            Text(text = "Año: ${book.publishYear}")

            Spacer(modifier = Modifier.height(8.dp))

            if (onLikeClick != null) {
                Button(onClick = { onLikeClick(book) }) {
                    Text("Me gusta")
                }
            }
        }
    }
}