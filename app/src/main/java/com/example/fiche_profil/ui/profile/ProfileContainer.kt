package com.example.fiche_profil.ui.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 * Composable Container : fait le pont entre le ViewModel et l'écran Stateless.
 */
@Composable
fun ProfileContainer(
    modifier: Modifier = Modifier,
    viewModel: ProfilViewModel = viewModel(),
    onContactClick: () -> Unit = {}
) {
    // 1. Collecter le StateFlow du ViewModel
    val uiState by viewModel.uiState.collectAsState()

    // 2. Transmettre l'état et les callbacks à l'écran Stateless (State Hoisting)
    ProfileScreen(
        uiState = uiState,
        onSearchQueryChange = viewModel::onSearchQueryChange,
        onToggleFavoriteFilter = viewModel::onToggleFavoriteFilter,
        onFavoriteClick = viewModel::onToggleFavorite,
        onContactClick = onContactClick,
        modifier = modifier
    )
}