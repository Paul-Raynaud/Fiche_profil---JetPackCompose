package com.example.fiche_profil.ui.profile

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fiche_profil.model.ProfileData
import com.example.fiche_profil.model.ProfileUiState
import com.example.fiche_profil.model.sampleJuniorProfile
import com.example.fiche_profil.model.sampleSeniorProfile
import com.example.fiche_profil.ui.theme.Fiche_profilTheme

/**
 * Composable racine de l'application utilisant Scaffold.
 */
@Composable
fun ProfileApp(
    uiState: ProfileUiState = ProfileUiState(),
    onSearchQueryChange: (String) -> Unit = {},
    onToggleFavoriteFilter: () -> Unit = {},
    onFavoriteClick: (String) -> Unit = {},
    onContactClick: () -> Unit = {},
    modifier : Modifier = Modifier
) {
    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        ProfileScreen(
            uiState = uiState,
            onSearchQueryChange = onSearchQueryChange,
            onToggleFavoriteFilter = onToggleFavoriteFilter,
            onFavoriteClick = onFavoriteClick,
            onContactClick = onContactClick,
            modifier = Modifier.padding(innerPadding)
        )
    }
}



@Preview(
    showBackground = true,
    name = "Preview 1 - Recherche vide & Tous les projets",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun ProfilePreview1() {
    Fiche_profilTheme(darkTheme = false) {
        ProfileScreen(
            uiState = ProfileUiState(
                profile = sampleJuniorProfile,
                searchQuery = "",
                showOnlyFavorites = false,
                favoriteProjectIds = emptySet()
            ),
            onSearchQueryChange = {},
            onToggleFavoriteFilter = {},
            onFavoriteClick = {},
            onContactClick = {}
        )
    }
}

// Preview 2 : Recherche active & Filtre favoris activé (Mode Sombre)
@Preview(
    showBackground = true,
    name = "Preview 2 - Recherche active & Filtre favoris (Sombre)",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun ProfilePreview2() {
    Fiche_profilTheme(darkTheme = true) {
        ProfileScreen(
            uiState = ProfileUiState(
                profile = sampleSeniorProfile,
                searchQuery = "Compose",
                showOnlyFavorites = true,
                favoriteProjectIds = setOf("101")
            ),
            onSearchQueryChange = {},
            onToggleFavoriteFilter = {},
            onFavoriteClick = {},
            onContactClick = {}
        )
    }
}
