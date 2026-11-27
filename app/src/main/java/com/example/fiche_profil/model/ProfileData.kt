package com.example.fiche_profil.model

/**
 * Modèle de données représentant le profil d'un développeur.
 */
data class ProfileData(
    val name: String,
    val role: String,
    val description: String,
    val isAvailable: Boolean = true,
    val skills: List<String>,
    val projects: List<ProjectData>,
    val contactInfo: ContactInfo,
    val buttonText: String
)

// Jeux de données de démonstration pour les Previews et l'application
val sampleJuniorProfile = ProfileData(
    name = "Alexandre Dupont",
    role = "Développeur Android Junior",
    description = "Passionné par le développement mobile natif et Jetpack Compose. À la recherche d'un stage de 6 mois.",
    skills = listOf("Kotlin", "Jetpack Compose", "Material 3", "Git", "Coroutines"),
    projects = listOf(
        ProjectData(
            id = "1",
            title = "Application Fiche Profil Compose",
            description = "Interface de profil réactive avec listes modernes et Material 3.",
            technologies = listOf("Kotlin", "Compose UI", "Material 3"),
            date = "2026"
        ),
        ProjectData(
            id = "2",
            title = "Gestionnaire de Tâches Local",
            description = "Application simple d'organisation avec sauvegarde locale.",
            technologies = listOf("Kotlin", "Compose", "Architecture Modulaire"),
            date = "2025"
        )
    ),
    contactInfo = ContactInfo(
        email = "alexandre.dupont@email.com",
        location = "Paris, France",
        availability = "Disponible pour un stage (Septembre 2026)",
        githubUrl = "github.com/alexandre-dupont"
    ),
    buttonText = "Télécharger le CV"
)

val sampleSeniorProfile = ProfileData(
    name = "Sarah Martin",
    role = "Développeuse Fullstack Mobile",
    description = "5 ans d'expérience dans la création d'applications Android et backend réactifs.",
    skills = listOf("Kotlin", "Compose", "Ktor", "Docker", "CI/CD"),
    projects = listOf(
        ProjectData(
            id = "101",
            title = "Plateforme E-Commerce Mobile",
            description = "Application mobile haute performance avec design Material 3.",
            technologies = listOf("Kotlin", "Jetpack Compose", "Design System"),
            date = "2026"
        )
    ),
    contactInfo = ContactInfo(
        email = "sarah.martin@email.com",
        location = "Lyon, France",
        availability = "En poste - Ouverte aux opportunités",
        githubUrl = "github.com/sarah-martin"
    ),
    buttonText = "Voir le Portfolio"
)
