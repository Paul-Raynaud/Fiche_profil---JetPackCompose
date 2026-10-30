package com.example.fiche_profil.model

/**
 * Modèle de données représentant le profil d'un développeur.
 */
data class ProfileData(
    val name: String,
    val role: String,
    val description: String,
    val skills: List<String>,
    val isAvailable: Boolean,
    val buttonText: String
)

// Jeux de données de démonstration pour les Previews et l'application
val sampleJuniorProfile = ProfileData(
    name = "Alexandre Dupont",
    role = "Développeur Android Junior",
    description = "Passionné par le développement mobile et Jetpack Compose. Recherche un stage de 6 mois à partir de septembre.",
    skills = listOf("Kotlin", "Jetpack Compose", "Git", "Material 3", "Coroutines"),
    isAvailable = true,
    buttonText = "Me contacter"
)

val sampleSeniorProfile = ProfileData(
    name = "Sarah Martin",
    role = "Développeuse Fullstack Mobile",
    description = "5 ans d'expérience dans la création d'applications Android & Backend. Spécialisée dans les architectures modernes.",
    skills = listOf("Kotlin", "Compose", "Node.js", "Ktor", "Docker", "CI/CD"),
    isAvailable = false,
    buttonText = "Voir le portfolio"
)
