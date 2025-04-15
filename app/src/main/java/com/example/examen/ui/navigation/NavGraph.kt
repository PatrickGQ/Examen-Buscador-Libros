package com.example.examen.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.examen.domain.model.Book
import com.example.examen.ui.saved.SavedBooksScreen
import com.example.examen.ui.search.SearchScreen
import com.example.examen.ui.search.SearchViewModel

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel,
    getSavedBooks: suspend () -> List<Book>
) {
    NavHost(
        navController = navController,
        startDestination = "search",
        modifier = modifier
    ) {
        composable("search") {
            SearchScreen(viewModel = viewModel, onNavigateToSaved = {
                navController.navigate("saved")
            })
        }
        composable("saved") {
            SavedBooksScreen(getSavedBooks = getSavedBooks)
        }
    }
}