package com.example.fiche_profil.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.fiche_profil.model.ProfileUiState
import com.example.fiche_profil.ui.components.ActionButton
import com.example.fiche_profil.ui.components.ProjectCard
import com.example.fiche_profil.ui.components.SectionTitle

/**
 * Écran principal STATELESS (State Hoisting exigé par le sujet).
 * Reçoit les valeurs et callbacks sous forme de paramètres.
 */
@Composable
fun ProfileScreen(
    uiState: ProfileUiState,
    onSearchQueryChange: (String) -> Unit,
    onToggleFavoriteFilter: () -> Unit,
    onFavoriteClick: (String) -> Unit,
    onContactClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 1. En-tête et profil
            item {
                ProfileHeader(
                    name = uiState.profile.name,
                    role = uiState.profile.role,
                    description = uiState.profile.description,
                    isAvailable = uiState.profile.isAvailable,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            // 2. Carrousel de compétences (LazyRow)
            item {
                SkillsSection(
                    skills = uiState.profile.skills,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))
            }

            // 3. BARRE DE RECHERCHE ET FILTRES FAVORIS
            item {
                Column(modifier = Modifier.fillMaxWidth()) {
                    SectionTitle(title = "Projets & Portfolio")
                    Spacer(modifier = Modifier.height(8.dp))

                    // Champ de recherche (Projet par titre ou technologie)
                    OutlinedTextField(
                        value = uiState.searchQuery,
                        onValueChange = onSearchQueryChange,
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Rechercher un projet ou une techno...") },
                        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Recherche") },
                        singleLine = true,
                        shape = RoundedCornerShape(12.dp)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Filtre Favoris uniquement et compteur de projets
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        FilterChip(
                            selected = uiState.showOnlyFavorites,
                            onClick = onToggleFavoriteFilter,
                            label = { Text("Favoris uniquement") },
                            leadingIcon = {
                                Icon(
                                    imageVector = if (uiState.showOnlyFavorites) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                    contentDescription = "Filtre favoris"
                                )
                            }
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        // COMPTEUR DYNAMIQUE DE PROJETS AFFICHÉS
                        Text(
                            text = "${uiState.visibleProjectsCount} projet(s) affiché(s)",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.outline,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                }
            }

            // 4. LISTE FILTRÉE DES PROJETS (ProjectCard)
            items(uiState.filteredProjects, key = { it.id }) { project ->
                ProjectCard(
                    project = project,
                    isFavorite = uiState.favoriteProjectIds.contains(project.id),
                    onFavoriteClick = { onFavoriteClick(project.id) },
                    modifier = Modifier.padding(bottom = 10.dp)
                )
            }

            // 5. Section Contact (avec état local rememberSaveable)
            item {
                Spacer(modifier = Modifier.height(12.dp))
                ContactSection(
                    contactInfo = uiState.profile.contactInfo,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))
            }

            // 6. Action principale
            item {
                ActionButton(
                    text = uiState.profile.buttonText,
                    onClick = onContactClick,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}