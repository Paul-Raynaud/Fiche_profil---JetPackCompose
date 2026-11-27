package com.example.fiche_profil.model

data class ProjectData(
    val id: String,
    val title: String,
    val description: String,
    val technologies: List<String>,
    val date: String
)