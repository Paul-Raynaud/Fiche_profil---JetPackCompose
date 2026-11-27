package com.example.fiche_profil.model



data class ProfileUiState(
    val profile : ProfileData = sampleJuniorProfile,
    val searchQuery: String = "",
    val showOnlyFavorites : Boolean = false,
    val favoriteProjectIds: Set<String> = emptySet()
) {
    val filteredProjects: List<ProjectData>
        get() = profile.projects.filter { project ->
            // Filtre 1 : Favoris si activé
            val matchesFavorite = !showOnlyFavorites || favoriteProjectIds.contains(project.id)

            // Filtre 2 : Recherche par titre ou par technologie
            val matchesQuery = searchQuery.isBlank() ||
                    project.title.contains(searchQuery, ignoreCase = true) ||
                    project.technologies.any { it.contains(searchQuery, ignoreCase = true) }

            matchesFavorite && matchesQuery
        }
    val visibleProjectsCount: Int
        get() = filteredProjects.size
}